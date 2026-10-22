/*
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */

package app.gyrolet.mpvrx.ui.player.controls

import android.content.Context
import android.graphics.Matrix
import android.graphics.SurfaceTexture
import android.media.MediaPlayer
import android.net.Uri
import android.util.Log
import android.view.Surface
import android.view.TextureView
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.compose.currentStateAsState
import androidx.lifecycle.repeatOnLifecycle
import app.gyrolet.mpvrx.data.artwork.AppleMusicArtworkRepository
import app.gyrolet.mpvrx.data.artwork.MotionArtworkQuery
import app.gyrolet.mpvrx.data.artwork.RemoteMotionArtwork
import java.io.IOException
import kotlinx.coroutines.delay
import org.koin.compose.koinInject

@Composable
internal fun RemoteMotionArtwork(
  query: MotionArtworkQuery,
  isPlaying: Boolean,
  modifier: Modifier = Modifier,
) {
  val repository = koinInject<AppleMusicArtworkRepository>()
  val lifecycleOwner = LocalLifecycleOwner.current
  var artwork by remember(query) { mutableStateOf<RemoteMotionArtwork?>(null) }
  LaunchedEffect(query, lifecycleOwner, repository) {
    lifecycleOwner.lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
      // Metadata can arrive in several updates; skip transient combinations during track changes.
      delay(600)
      artwork = repository.find(query)
    }
  }
  val lifecycleState by lifecycleOwner.lifecycle.currentStateAsState()
  if (lifecycleState.isAtLeast(Lifecycle.State.STARTED)) {
    artwork?.let { result ->
      key(query, result) {
        MotionArtworkVideo(artwork = result, isPlaying = isPlaying, modifier = modifier)
      }
    }
  }
}

@Composable
private fun MotionArtworkVideo(
  artwork: RemoteMotionArtwork,
  isPlaying: Boolean,
  modifier: Modifier,
) {
  val repository = koinInject<AppleMusicArtworkRepository>()
  var sourceIndex by remember { mutableIntStateOf(0) }
  var failed by remember { mutableStateOf(false) }
  if (failed) return

  key(sourceIndex) {
    var firstFrame by remember { mutableStateOf(false) }
    var playbackUrl by remember { mutableStateOf<String?>(null) }
    val attempt = sourceIndex
    val retryOrFallBack = {
      if (sourceIndex == attempt) {
        if (sourceIndex < artwork.urls.lastIndex) sourceIndex++ else failed = true
      }
    }
    LaunchedEffect(artwork.urls[attempt]) {
      try {
        playbackUrl = repository.resolvePlaybackUrl(artwork.urls[attempt])
      } catch (e: IOException) {
        Log.w("MotionArtworkVideo", "Artwork playlist unavailable; trying another rendition or retaining the cover")
        retryOrFallBack()
      }
    }
    LaunchedEffect(firstFrame) {
      if (!firstFrame) {
        delay(20_000)
        Log.w("MotionArtworkVideo", "Artwork first frame timed out; trying another rendition or retaining the cover")
        retryOrFallBack()
      }
    }
    val source = playbackUrl
    if (source != null) {
      AndroidView(
        modifier = modifier,
        factory = { context ->
          MotionArtworkTextureView(
            context = context,
            url = source,
            onFrameReady = { firstFrame = it },
            onFailure = retryOrFallBack,
          )
        },
        update = { view ->
          // A Compose alpha=0 layer can suppress TextureView drawing and its first-frame
          // callback. Blend on the View itself, leaving the still cover underneath.
          view.alpha = if (firstFrame) 1f else 0f
          view.setPlaying(isPlaying)
        },
        onRelease = { view -> view.releasePlayer() },
      )
    }
  }
}

/** Muted, looping platform playback for artwork, independent of the main music player. */
private class MotionArtworkTextureView(
  context: Context,
  private val url: String,
  private val onFrameReady: (Boolean) -> Unit,
  private val onFailure: () -> Unit,
) : TextureView(context), TextureView.SurfaceTextureListener {
  private var player: MediaPlayer? = null
  private var outputSurface: Surface? = null
  private var prepared = false
  private var playing = false
  private var started = false
  private var released = false
  private var failed = false
  private var frameReady = false
  private var videoAspect = 1f

  init {
    isOpaque = false
    isClickable = false
    isFocusable = false
    importantForAccessibility = IMPORTANT_FOR_ACCESSIBILITY_NO
    alpha = 0f
    surfaceTextureListener = this
  }

  fun setPlaying(value: Boolean) {
    playing = value
    val current = player ?: return
    if (!prepared || started == value) return
    try {
      if (value) current.start() else current.pause()
      started = value
    } catch (e: IllegalStateException) {
      fail("Artwork decoder could not change playback state", e)
    }
  }

  override fun onSurfaceTextureAvailable(texture: SurfaceTexture, width: Int, height: Int) {
    if (released || failed) return
    try {
      val current = MediaPlayer()
      player = current
      outputSurface = Surface(texture)
      current.setVolume(0f, 0f)
      current.setSurface(outputSurface)
      current.setOnPreparedListener {
        if (player === it && !released) {
          try {
            prepared = true
            it.isLooping = true
            // Seeking in Prepared state paints one frame even while the song is paused.
            if (playing) setPlaying(true) else it.seekTo(0)
          } catch (e: IllegalStateException) {
            fail("Artwork decoder could not finish preparing", e)
          }
        }
      }
      current.setOnVideoSizeChangedListener { owner, videoWidth, videoHeight ->
        if (player === owner && videoWidth > 0 && videoHeight > 0) {
          videoAspect = videoWidth.toFloat() / videoHeight
          updateCrop()
        }
      }
      current.setOnCompletionListener {
        if (player === it && !released) {
          started = false
          setPlaying(playing)
        }
      }
      current.setOnErrorListener { owner, what, extra ->
        if (player === owner) fail("Artwork decoder error ($what/$extra)")
        true
      }
      current.setDataSource(context, Uri.parse(url), AppleMusicArtworkRepository.playbackHeaders)
      current.prepareAsync()
    } catch (e: IOException) {
      fail("Could not open artwork stream", e)
    } catch (e: IllegalArgumentException) {
      fail("Unsupported artwork stream", e)
    } catch (e: IllegalStateException) {
      fail("Artwork decoder could not prepare", e)
    } catch (e: SecurityException) {
      fail("Artwork stream access denied", e)
    }
  }

  override fun onSurfaceTextureSizeChanged(texture: SurfaceTexture, width: Int, height: Int) = updateCrop()

  override fun onSurfaceTextureDestroyed(texture: SurfaceTexture): Boolean {
    releaseDecoder()
    alpha = 0f
    frameReady = false
    if (!released) onFrameReady(false)
    return true
  }

  override fun onSurfaceTextureUpdated(texture: SurfaceTexture) {
    if (prepared && !frameReady && !released && !failed) {
      frameReady = true
      onFrameReady(true)
    }
  }

  private fun updateCrop() {
    if (width <= 0 || height <= 0) return
    val viewAspect = width.toFloat() / height
    val scaleX = if (videoAspect > viewAspect) videoAspect / viewAspect else 1f
    val scaleY = if (videoAspect < viewAspect) viewAspect / videoAspect else 1f
    setTransform(Matrix().apply { setScale(scaleX, scaleY, width / 2f, height / 2f) })
  }

  private fun fail(message: String, cause: Exception? = null) {
    if (failed || released) return
    failed = true
    Log.w("MotionArtworkVideo", "$message; trying another rendition or retaining the cover", cause)
    releasePlayer()
    alpha = 0f
    onFrameReady(false)
    onFailure()
  }

  fun releasePlayer() {
    if (released) return
    released = true
    releaseDecoder()
    surfaceTextureListener = null
  }

  private fun releaseDecoder() {
    val current = player
    player = null
    prepared = false
    started = false
    current?.setOnPreparedListener(null)
    current?.setOnVideoSizeChangedListener(null)
    current?.setOnCompletionListener(null)
    current?.setOnErrorListener(null)
    current?.release()
    outputSurface?.release()
    outputSurface = null
  }
}

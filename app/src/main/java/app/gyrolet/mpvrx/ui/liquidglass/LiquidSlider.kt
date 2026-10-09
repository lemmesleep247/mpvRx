// Adapted from Square's Backdrop catalog LiquidSlider, Apache-2.0.
// https://github.com/Lelonio/Square
// https://github.com/Kyant0/AndroidLiquidGlass
// Upstream catalog commit: b18eb0ff12c616546a68c72e7d0097f1ab286c87.
// App changes: shared optics, enabled state, completion callbacks and reduced motion.

package app.gyrolet.mpvrx.ui.liquidglass

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.awaitEachGesture
import androidx.compose.foundation.gestures.awaitFirstDown
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.scale
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.input.pointer.positionChanged
import androidx.compose.ui.layout.layout
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.fastCoerceIn
import androidx.compose.ui.util.fastRoundToInt
import androidx.compose.ui.util.lerp
import androidx.compose.ui.zIndex
import app.gyrolet.mpvrx.ui.theme.AppMotion
import com.kyant.backdrop.Backdrop
import com.kyant.backdrop.backdrops.layerBackdrop
import com.kyant.backdrop.backdrops.rememberBackdrop
import com.kyant.backdrop.backdrops.rememberCombinedBackdrop
import com.kyant.backdrop.backdrops.rememberLayerBackdrop
import com.kyant.backdrop.drawBackdrop
import com.kyant.backdrop.highlight.Highlight
import com.kyant.backdrop.shadow.InnerShadow
import com.kyant.backdrop.shadow.Shadow
import com.kyant.shapes.Capsule
import kotlinx.coroutines.flow.collectLatest

@Composable
fun LiquidSlider(
  value: () -> Float,
  onValueChange: (Float) -> Unit,
  valueRange: ClosedFloatingPointRange<Float>,
  visibilityThreshold: Float,
  backdrop: Backdrop,
  modifier: Modifier = Modifier,
  accentColor: Color,
  trackColor: Color,
  steps: Int = 0,
  enabled: Boolean = true,
  onValueChangeFinished: (() -> Unit)? = null,
) {
  val trackBackdrop = rememberLayerBackdrop()
  val settings = rememberLiquidGlassSettings()
  val reduceMotion = AppMotion.shouldReduceMotion()
  val currentValue = rememberUpdatedState(value)
  val currentOnValueChange = rememberUpdatedState(onValueChange)
  val currentOnFinished = rememberUpdatedState(onValueChangeFinished)
  val isLtr = LocalLayoutDirection.current == LayoutDirection.Ltr
  val animationScope = rememberCoroutineScope()
  // Reserve room for the expanded (pressed) glass thumb and its shadow at both ends.
  val thumbWidth = 40.dp
  val thumbEdgePadding = 16.dp
  val trackEndInset = thumbWidth / 2 + thumbEdgePadding
  val density = LocalDensity.current

  BoxWithConstraints(
    modifier.fillMaxWidth().height(48.dp),
    contentAlignment = Alignment.CenterStart,
  ) {
    val sliderWidthPx = constraints.maxWidth.toFloat()
    val trackInsetPx = with(density) { trackEndInset.toPx() }
    val thumbEdgePaddingPx = with(density) { thumbEdgePadding.toPx() }
    val usableTrackWidthPx = (sliderWidthPx - 2f * trackInsetPx).coerceAtLeast(0f)
    val animation = remember(animationScope, valueRange, visibilityThreshold, reduceMotion) {
      DampedDragAnimation(
        animationScope = animationScope,
        initialValue = currentValue.value(),
        valueRange = valueRange,
        visibilityThreshold = visibilityThreshold,
        initialScale = 1f,
        pressedScale = if (reduceMotion) 1f else 1.5f,
        onDragStarted = {},
        onDragStopped = {},
        onDrag = { _, _ -> },
      )
    }
    LaunchedEffect(animation, reduceMotion) {
      snapshotFlow { currentValue.value() }.collectLatest { changedValue ->
        if (animation.targetValue != changedValue) {
          if (reduceMotion) animation.snapToValue(changedValue) else animation.updateValue(changedValue)
        }
      }
    }

    if (enabled) {
      Box(
        Modifier.matchParentSize()
          .pointerInput(animation, usableTrackWidthPx, trackInsetPx, isLtr, enabled) {
            fun seekTo(horizontalPosition: Float) {
              if (usableTrackWidthPx <= 0f) return
              val fraction = ((horizontalPosition - trackInsetPx) / usableTrackWidthPx).coerceIn(0f, 1f)
              val delta = (valueRange.endInclusive - valueRange.start) * fraction
              val target = (if (isLtr) valueRange.start + delta else valueRange.endInclusive - delta)
                .coerceIn(valueRange)
              currentOnValueChange.value(target)
            }
            awaitEachGesture {
              val down = awaitFirstDown(requireUnconsumed = true)
              if (!reduceMotion) animation.press()
              down.consume()
              seekTo(down.position.x)
              var completed = false
              try {
                while (true) {
                  val change = awaitPointerEvent().changes.firstOrNull { it.id == down.id } ?: break
                  if (!change.pressed) {
                    completed = true
                    break
                  }
                  if (change.positionChanged()) {
                    change.consume()
                    seekTo(change.position.x)
                  }
                }
              } finally {
                if (!reduceMotion) animation.release()
                if (completed) currentOnFinished.value?.invoke()
              }
            }
          }.zIndex(1f),
      )
    }

    Box(Modifier.fillMaxWidth().padding(horizontal = trackEndInset).layerBackdrop(trackBackdrop)) {
      Box(
        Modifier.clip(Capsule())
          .background(trackColor)
          .height(6.dp)
          .fillMaxWidth(),
      )
      Box(
        Modifier.clip(Capsule())
          .background(accentColor)
          .height(6.dp)
          .layout { measurable, trackConstraints ->
            val placeable = measurable.measure(trackConstraints)
            val width = (trackConstraints.maxWidth * animation.progress.coerceIn(0f, 1f)).fastRoundToInt()
            layout(width, placeable.height) { placeable.placeRelative(0, 0) }
          },
      )
      if (steps > 0) {
        Canvas(Modifier.fillMaxWidth().height(6.dp)) {
          val intervalCount = steps.toLong() + 1L
          val tickSpacing = size.width / intervalCount
          if (tickSpacing >= 4.dp.toPx()) {
            for (tickIndex in 0..intervalCount.toInt()) {
              val fraction = tickIndex.toFloat() / intervalCount
              val horizontalPosition = if (isLtr) size.width * fraction else size.width * (1f - fraction)
              drawCircle(
                color = if (fraction <= animation.progress) Color.White.copy(alpha = 0.7f) else accentColor.copy(alpha = 0.7f),
                radius = 1.dp.toPx(),
                center = androidx.compose.ui.geometry.Offset(horizontalPosition, size.height / 2f),
              )
            }
          }
        }
      }
    }

    val combinedBackdrop = rememberCombinedBackdrop(
      backdrop,
      rememberBackdrop(trackBackdrop) { drawTrack ->
        val progress = animation.pressProgress
        scale(lerp(2f / 3f, 1f, progress), lerp(0f, 1f, progress)) { drawTrack() }
      },
    )
    // A translucent themed film keeps both the accent and the refracted content visible.
    val film = androidx.compose.ui.graphics.lerp(
      MaterialTheme.colorScheme.surfaceContainerHigh,
      accentColor,
      0.18f,
    ).copy(alpha = if (enabled) 0.72f - 0.28f * animation.pressProgress else 0.32f)
    // The idle thumb stays white; pressing it reveals the existing themed glass film.
    val thumbFilm = androidx.compose.ui.graphics.lerp(
      Color.White,
      film,
      animation.pressProgress.coerceIn(0f, 1f),
    )
    val thumbModifier = Modifier.drawBackdrop(
          backdrop = combinedBackdrop,
          shape = { Capsule() },
          effects = {
            val progress = animation.pressProgress
            liquidGlassEffects(
              settings,
              8.dp.toPx() * (1f - progress),
              10.dp.toPx() * progress,
              14.dp.toPx() * progress,
              refractionEnabled = enabled && !reduceMotion,
            )
          },
          highlight = {
            val progress = animation.pressProgress
            settings.highlight(Highlight.Ambient.copy(
              width = Highlight.Ambient.width / 1.5f,
              blurRadius = Highlight.Ambient.blurRadius / 1.5f,
              alpha = progress,
            ))
          },
          shadow = { settings.shadow(Shadow(radius = 4.dp, color = Color.Black.copy(alpha = 0.05f))) },
          innerShadow = {
            val progress = animation.pressProgress
            settings.innerShadow(InnerShadow(radius = 4.dp * progress, alpha = progress))
          },
          layerBlock = {
            scaleX = animation.scaleX
            scaleY = animation.scaleY
            val velocity = animation.velocity / 10f
            scaleX /= 1f - (velocity * 0.75f).fastCoerceIn(-0.2f, 0.2f)
            scaleY *= 1f - (velocity * 0.25f).fastCoerceIn(-0.2f, 0.2f)
          },
          onDrawSurface = { drawRect(settings.surfaceColor(thumbFilm)) },
        )
    Box(
      Modifier.graphicsLayer {
        // The thumb center coincides with the track endpoints without ever leaving its viewport.
        translationX = (thumbEdgePaddingPx + usableTrackWidthPx * animation.progress.coerceIn(0f, 1f)) *
          if (isLtr) 1f else -1f
      }.then(thumbModifier).size(40.dp, 24.dp),
    )
  }
}
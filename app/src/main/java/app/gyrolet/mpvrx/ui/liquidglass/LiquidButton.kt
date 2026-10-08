/*
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */

package app.gyrolet.mpvrx.ui.liquidglass

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.background
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.isSpecified
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.util.fastCoerceAtMost
import androidx.compose.ui.util.lerp
import com.kyant.backdrop.Backdrop
import com.kyant.backdrop.drawBackdrop
import com.kyant.backdrop.highlight.Highlight
import com.kyant.backdrop.shadow.Shadow
import com.kyant.shapes.Capsule
import kotlin.math.abs
import kotlin.math.atan2
import kotlin.math.cos
import kotlin.math.sin
import kotlin.math.tanh

/**
 * App adapter for Kyant's catalog LiquidButton.
 *
 * The optical effect and interaction geometry intentionally match the upstream component. The
 * adapter only adds long-click support and configurable dimensions required by player controls.
 */
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun LiquidButton(
  onClick: () -> Unit,
  backdrop: Backdrop,
  modifier: Modifier = Modifier,
  onLongClick: () -> Unit = {},
  enabled: Boolean = true,
  tint: Color = Color.Unspecified,
  surfaceColor: Color = Color.Unspecified,
  height: Dp = 48.dp,
  horizontalPadding: Dp = 16.dp,
  spacing: Dp = 8.dp,
  content: @Composable RowScope.() -> Unit,
) {
  val glassSettings = rememberLiquidGlassSettings()
  if (glassSettings.transparent) {
    val filmColor = if (surfaceColor.isSpecified) surfaceColor else MaterialTheme.colorScheme.surfaceContainerHigh.copy(alpha = 0.32f)
    Row(
      modifier = modifier
        .clip(Capsule())
        .background(glassSettings.surfaceColor(filmColor))
        .combinedClickable(
          enabled = enabled,
          role = Role.Button,
          onClick = onClick,
          onLongClick = onLongClick,
        )
        .height(height)
        .padding(horizontal = horizontalPadding),
      horizontalArrangement = Arrangement.spacedBy(spacing, Alignment.CenterHorizontally),
      verticalAlignment = Alignment.CenterVertically,
      content = content,
    )
    return
  }
  val animationScope = rememberCoroutineScope()
  val interactiveHighlight =
    remember(animationScope) {
      InteractiveHighlight(animationScope = animationScope)
    }

  Row(
    modifier =
      modifier
        .drawBackdrop(
          backdrop = backdrop,
          shape = { Capsule() },
          effects = {
            liquidGlassEffects(glassSettings, 2.dp.toPx(), 12.dp.toPx(), 24.dp.toPx(), vibrant = true)
          },
          highlight = { glassSettings.highlight(Highlight.Default) },
          shadow = { glassSettings.shadow(Shadow.Default) },
          layerBlock =
            if (enabled) {
              {
                val width = size.width
                val heightPx = size.height
                val progress = interactiveHighlight.pressProgress
                val scale = lerp(1f, 1f + 4.dp.toPx() / heightPx, progress)
                val maxOffset = size.minDimension
                val offset = interactiveHighlight.offset
                translationX = maxOffset * tanh(0.05f * offset.x / maxOffset)
                translationY = maxOffset * tanh(0.05f * offset.y / maxOffset)

                val maxDragScale = 4.dp.toPx() / heightPx
                val offsetAngle = atan2(offset.y, offset.x)
                scaleX =
                  scale +
                    maxDragScale * abs(cos(offsetAngle) * offset.x / size.maxDimension) *
                    (width / heightPx).fastCoerceAtMost(1f)
                scaleY =
                  scale +
                    maxDragScale * abs(sin(offsetAngle) * offset.y / size.maxDimension) *
                    (heightPx / width).fastCoerceAtMost(1f)
              }
            } else {
              null
            },
          onDrawSurface = {
            if (tint.isSpecified) {
              drawRect(tint, blendMode = BlendMode.Hue)
              drawRect(glassSettings.surfaceColor(tint.copy(alpha = 0.75f)))
            }
            if (surfaceColor.isSpecified) drawRect(glassSettings.surfaceColor(surfaceColor))
          },
        ).combinedClickable(
          enabled = enabled,
          interactionSource = null,
          indication = if (enabled) null else LocalIndication.current,
          role = Role.Button,
          onClick = onClick,
          onLongClick = onLongClick,
        ).then(
          if (enabled) {
            Modifier
              .then(interactiveHighlight.modifier)
              .then(interactiveHighlight.gestureModifier)
          } else {
            Modifier
          },
        ).height(height)
        .padding(horizontal = horizontalPadding),
    horizontalArrangement = Arrangement.spacedBy(spacing, Alignment.CenterHorizontally),
    verticalAlignment = Alignment.CenterVertically,
    content = content,
  )
}

package app.gyrolet.mpvrx.ui.components

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsDraggedAsState
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SliderColors
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.SliderState
import androidx.compose.material3.RangeSliderState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import app.gyrolet.mpvrx.preferences.AppearancePreferences
import app.gyrolet.mpvrx.preferences.preference.collectAsState
import app.gyrolet.mpvrx.ui.liquidglass.LocalKyantPlayerBackdrop
import app.gyrolet.mpvrx.ui.liquidglass.liquidGlassEffects
import app.gyrolet.mpvrx.ui.liquidglass.rememberLiquidGlassSettings
import app.gyrolet.mpvrx.ui.theme.AppMotion
import com.kyant.backdrop.backdrops.rememberCanvasBackdrop
import com.kyant.backdrop.Backdrop
import com.kyant.backdrop.backdrops.layerBackdrop
import com.kyant.backdrop.backdrops.rememberLayerBackdrop
import com.kyant.backdrop.backdrops.rememberCombinedBackdrop
import com.kyant.backdrop.drawBackdrop
import com.kyant.backdrop.highlight.Highlight
import com.kyant.backdrop.shadow.InnerShadow
import com.kyant.backdrop.shadow.Shadow
import com.kyant.shapes.Capsule
import org.koin.compose.koinInject

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppSlider(
  value: Float,
  onValueChange: (Float) -> Unit,
  modifier: Modifier = Modifier,
  enabled: Boolean = true,
  valueRange: ClosedFloatingPointRange<Float> = 0f..1f,
  steps: Int = 0,
  onValueChangeFinished: (() -> Unit)? = null,
  colors: SliderColors = SliderDefaults.colors(),
  interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
) {
  val appearancePreferences = koinInject<AppearancePreferences>()
  val glassEnabled by appearancePreferences.liquidGlassEnabled.collectAsState()
  if (!glassEnabled) {
    androidx.compose.material3.Slider(
      value = value,
      onValueChange = onValueChange,
      modifier = modifier,
      enabled = enabled,
      valueRange = valueRange,
      steps = steps,
      onValueChangeFinished = onValueChangeFinished,
      colors = colors,
      interactionSource = interactionSource,
    )
    return
  }

  val sliderState = remember(steps, valueRange) { SliderState(value, steps, valueRange) }
  sliderState.value = value
  val trackBackdrop = rememberLayerBackdrop()

  androidx.compose.material3.Slider(
    state = sliderState,
    onValueChange = onValueChange,
    modifier = modifier,
    enabled = enabled,
    onValueChangeFinished = onValueChangeFinished,
    colors = colors,
    interactionSource = interactionSource,
    thumb = { GlassSliderThumb(interactionSource, enabled, colors, trackBackdrop) },
    track = { sliderState ->
      SliderDefaults.Track(
        sliderState = sliderState,
        modifier = Modifier.height(6.dp).layerBackdrop(trackBackdrop),
        enabled = enabled,
        colors = colors,
      )
    },
  )
}

@Composable
private fun GlassSliderThumb(
  interactionSource: MutableInteractionSource,
  enabled: Boolean,
  colors: SliderColors,
  trackBackdrop: Backdrop,
) {
  val settings = rememberLiquidGlassSettings()
  val pressed by interactionSource.collectIsPressedAsState()
  val dragged by interactionSource.collectIsDraggedAsState()
  val interacting = enabled && (pressed || dragged)
  val reduceMotion = AppMotion.shouldReduceMotion()
  val surfaceColor = MaterialTheme.colorScheme.surfaceContainerHigh
  val canvasBackdrop = rememberCanvasBackdrop { drawRect(surfaceColor) }
  val backgroundBackdrop = LocalKyantPlayerBackdrop.current ?: canvasBackdrop
  val backdrop = rememberCombinedBackdrop(backgroundBackdrop, trackBackdrop)
  val baseTint = if (enabled) colors.thumbColor else colors.disabledThumbColor
  val tint = baseTint.copy(alpha = baseTint.alpha * if (interacting) 0.22f else 0.72f)
  val materialModifier =
    if (settings.transparent) {
      Modifier.clip(CircleShape).background(settings.surfaceColor(tint))
    } else {
      Modifier.drawBackdrop(
        backdrop = backdrop,
        shape = { Capsule() },
        effects = {
          liquidGlassEffects(
            settings,
            blurRadius = if (interacting) 2.dp.toPx() else 8.dp.toPx(),
            refractionHeight = if (interacting) 10.dp.toPx() else 2.dp.toPx(),
            refractionAmount = if (interacting) 14.dp.toPx() else 2.dp.toPx(),
            refractionEnabled = enabled && !reduceMotion,
          )
        },
        highlight = { settings.highlight(Highlight.Ambient) },
        shadow = { settings.shadow(Shadow(radius = 4.dp)) },
        innerShadow = { settings.innerShadow(InnerShadow(radius = 4.dp)) },
        onDrawSurface = { drawRect(settings.surfaceColor(tint)) },
      )
    }
  Box(Modifier.size(40.dp, 24.dp).then(materialModifier))
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppRangeSlider(
  value: ClosedFloatingPointRange<Float>,
  onValueChange: (ClosedFloatingPointRange<Float>) -> Unit,
  modifier: Modifier = Modifier,
  enabled: Boolean = true,
  valueRange: ClosedFloatingPointRange<Float> = 0f..1f,
  steps: Int = 0,
  onValueChangeFinished: (() -> Unit)? = null,
  colors: SliderColors = SliderDefaults.colors(),
) {
  val preferences = koinInject<AppearancePreferences>()
  val glassEnabled by preferences.liquidGlassEnabled.collectAsState()
  if (!glassEnabled) {
    androidx.compose.material3.RangeSlider(
      value = value,
      onValueChange = onValueChange,
      modifier = modifier,
      enabled = enabled,
      valueRange = valueRange,
      steps = steps,
      onValueChangeFinished = onValueChangeFinished,
      colors = colors,
    )
    return
  }
  val state = remember(steps, valueRange) { RangeSliderState(value.start, value.endInclusive, steps, valueRange) }
  state.startValue = value.start
  state.endValue = value.endInclusive
  val startInteraction = remember { MutableInteractionSource() }
  val endInteraction = remember { MutableInteractionSource() }
  val trackBackdrop = rememberLayerBackdrop()
  androidx.compose.material3.RangeSlider(
    state = state,
    onValueChange = onValueChange,
    modifier = modifier,
    enabled = enabled,
    onValueChangeFinished = onValueChangeFinished,
    colors = colors,
    startThumbInteractionSource = startInteraction,
    endThumbInteractionSource = endInteraction,
    startThumb = { GlassSliderThumb(startInteraction, enabled, colors, trackBackdrop) },
    endThumb = { GlassSliderThumb(endInteraction, enabled, colors, trackBackdrop) },
    track = { rangeState ->
      SliderDefaults.Track(
        rangeSliderState = rangeState,
        modifier = Modifier.height(6.dp).layerBackdrop(trackBackdrop),
        enabled = enabled,
        colors = colors,
      )
    },
  )
}
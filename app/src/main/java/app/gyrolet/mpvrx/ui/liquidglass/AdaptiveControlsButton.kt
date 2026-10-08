/*
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */

package app.gyrolet.mpvrx.ui.liquidglass

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.ripple
import androidx.compose.material3.minimumInteractiveComponentSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import app.gyrolet.mpvrx.preferences.AppearancePreferences
import app.gyrolet.mpvrx.preferences.preference.collectAsState
import app.gyrolet.mpvrx.ui.icons.AppIcon
import app.gyrolet.mpvrx.ui.icons.Icon
import app.gyrolet.mpvrx.ui.player.controls.LocalPlayerButtonsClickEvent
import app.gyrolet.mpvrx.ui.player.controls.PlayerButtonAlpha
import app.gyrolet.mpvrx.ui.player.controls.components.playerButtonContainerColor
import app.gyrolet.mpvrx.ui.player.controls.components.playerButtonContentColor
import app.gyrolet.mpvrx.ui.theme.spacing
import com.kyant.backdrop.Backdrop
import org.koin.compose.koinInject

@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun AdaptiveControlsButton(
  onClick: () -> Unit,
  modifier: Modifier = Modifier,
  icon: AppIcon? = null,
  onLongClick: () -> Unit = {},
  text: String? = null,
  title: String? = null,
  color: Color? = null,
  surfaceColor: Color = Color.Unspecified,
  buttonSize: Dp = 40.dp,
  useGlass: Boolean = true,
  backdrop: Backdrop? = LocalKyantPlayerBackdrop.current,
) {
  val preferences = koinInject<AppearancePreferences>()
  val liquidGlassEnabled by preferences.liquidGlassEnabled.collectAsState()
  val clickEvent = LocalPlayerButtonsClickEvent.current
  val resolvedTint = color ?: if (liquidGlassEnabled) PlayerLiquidTokens.contentColor else playerButtonContentColor()
  val resolvedSurface =
    surfaceColor.takeUnless { it == Color.Unspecified }
      ?: if (liquidGlassEnabled) PlayerLiquidTokens.surfaceColor else playerButtonContainerColor()

  if (liquidGlassEnabled) {
    LiquidPillButton(
      onClick = {
        clickEvent()
        onClick()
      },
      onLongClick = onLongClick,
      backdrop = backdrop,
      modifier = modifier.height(buttonSize).widthIn(min = buttonSize),
      tint = resolvedTint,
      surfaceColor = resolvedSurface,
      height = buttonSize,
      horizontalPadding = if (text != null) 8.dp else 0.dp,
      spacing = 4.dp,
      useGlass = useGlass,
    ) {
      if (icon != null) {
        Icon(
          imageVector = icon,
          contentDescription = title ?: text,
          tint = resolvedTint,
          modifier = Modifier.size(PlayerLiquidTokens.IconSize),
        )
      }
      if (text != null) {
        Text(
          text = text,
          style = MaterialTheme.typography.labelLarge,
          color = resolvedTint,
          maxLines = 1,
        )
      }
    }
  } else {
    val hideBackground by preferences.hidePlayerButtonsBackground.collectAsState()
    val interactionSource = remember { MutableInteractionSource() }
    Surface(
      modifier =
        modifier
          .minimumInteractiveComponentSize()
          .clip(CircleShape)
          .combinedClickable(
            role = Role.Button,
            onClick = {
              clickEvent()
              onClick()
            },
            onLongClick = onLongClick,
            interactionSource = interactionSource,
            indication = ripple(),
          ),
      shape = CircleShape,
      color = if (hideBackground) Color.Transparent else resolvedSurface,
      contentColor = resolvedTint,
      tonalElevation = 0.dp,
      shadowElevation = 0.dp,
      border =
        if (hideBackground || !useGlass) {
          null
        } else {
          BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant.copy(alpha = PlayerButtonAlpha.BORDER))
        },
    ) {
      Row(
        modifier =
          Modifier
            .padding(horizontal = if (text != null) 8.dp else 0.dp)
            .heightIn(min = buttonSize)
            .widthIn(min = buttonSize),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
      ) {
        if (icon != null) {
          Icon(
            imageVector = icon,
            contentDescription = title ?: text,
            tint = resolvedTint,
            modifier =
              Modifier
                .padding(if (text == null) MaterialTheme.spacing.small else 0.dp)
                .size(20.dp),
          )
        }
        if (text != null) {
          if (icon != null) Spacer(Modifier.width(4.dp))
          Text(
            text = text,
            style = MaterialTheme.typography.labelLargeEmphasized,
            color = resolvedTint,
            maxLines = 1,
          )
        }
      }
    }
  }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun AdaptiveControlsContainer(
  onClick: () -> Unit,
  modifier: Modifier = Modifier,
  onLongClick: () -> Unit = {},
  color: Color = Color.Unspecified,
  surfaceColor: Color = Color.Unspecified,
  isInteractive: Boolean = true,
  useGlass: Boolean = true,
  hideBackground: Boolean = false,
  buttonSize: Dp = 40.dp,
  spacing: Dp = 8.dp,
  horizontalPadding: Dp? = null,
  backdrop: Backdrop? = LocalKyantPlayerBackdrop.current,
  content: @Composable RowScope.() -> Unit,
) {
  val preferences = koinInject<AppearancePreferences>()
  val liquidGlassEnabled by preferences.liquidGlassEnabled.collectAsState()
  val clickEvent = LocalPlayerButtonsClickEvent.current
  val resolvedTint =
    color.takeUnless { it == Color.Unspecified }
      ?: if (liquidGlassEnabled) PlayerLiquidTokens.contentColor else playerButtonContentColor()
  val resolvedSurface =
    surfaceColor.takeUnless { it == Color.Unspecified }
      ?: if (liquidGlassEnabled) PlayerLiquidTokens.surfaceColor else playerButtonContainerColor()

  if (liquidGlassEnabled) {
    LiquidPillButton(
      onClick = {
        if (isInteractive) clickEvent()
        onClick()
      },
      onLongClick = onLongClick,
      modifier = modifier,
      isInteractive = isInteractive,
      useGlass = useGlass,
      tint = resolvedTint,
      surfaceColor = resolvedSurface,
      height = buttonSize,
      spacing = spacing,
      horizontalPadding = horizontalPadding ?: 8.dp,
      backdrop = backdrop,
      content = content,
    )
  } else {
    Surface(
      shape = CircleShape,
      color = if (hideBackground) Color.Transparent else resolvedSurface,
      contentColor = resolvedTint,
      tonalElevation = 0.dp,
      shadowElevation = 0.dp,
      border =
        if (hideBackground || !useGlass) {
          null
        } else {
          BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant.copy(alpha = PlayerButtonAlpha.BORDER))
        },
      modifier =
        modifier
          .then(if (isInteractive) Modifier.minimumInteractiveComponentSize() else Modifier)
          .heightIn(min = buttonSize)
          .clip(CircleShape)
          .then(
            if (isInteractive) {
              Modifier.combinedClickable(
                role = Role.Button,
                interactionSource = remember { MutableInteractionSource() },
                indication = ripple(bounded = true),
                onClick = {
                  clickEvent()
                  onClick()
                },
                onLongClick = onLongClick,
              )
            } else {
              Modifier
            },
          ),
    ) {
      Box(contentAlignment = Alignment.Center) {
        Row(
          verticalAlignment = Alignment.CenterVertically,
          modifier = Modifier.padding(horizontal = horizontalPadding ?: MaterialTheme.spacing.small),
          horizontalArrangement = Arrangement.spacedBy(spacing),
          content = content,
        )
      }
    }
  }
}

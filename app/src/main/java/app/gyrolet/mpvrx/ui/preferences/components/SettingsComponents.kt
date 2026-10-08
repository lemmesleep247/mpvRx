/*
 * SPDX-License-Identifier: AGPL-3.0-or-later
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published
 * by the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 */

package app.gyrolet.mpvrx.ui.preferences.components

import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.heading
import androidx.compose.ui.semantics.role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.toggleableState
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import app.gyrolet.mpvrx.ui.components.IconSwitch
import app.gyrolet.mpvrx.ui.icons.AppIcon
import app.gyrolet.mpvrx.ui.icons.Icon
import app.gyrolet.mpvrx.ui.icons.Icons
import app.gyrolet.mpvrx.ui.player.controls.components.tvFocusHighlight
import app.gyrolet.mpvrx.ui.theme.spacing

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun SettingsClickableItem(
  title: String,
  modifier: Modifier = Modifier,
  description: String? = null,
  icon: AppIcon? = null,
  enabled: Boolean = true,
  onClick: () -> Unit = {},
  isFirstItem: Boolean = false,
  isLastItem: Boolean = false,
  trailing: @Composable (() -> Unit)? = null,
) {
  val groupShape = MaterialTheme.shapes.large
  val squareCorner = CornerSize(0.dp)
  val shape =
    groupShape.copy(
      topStart = if (isFirstItem) groupShape.topStart else squareCorner,
      topEnd = if (isFirstItem) groupShape.topEnd else squareCorner,
      bottomStart = if (isLastItem) groupShape.bottomStart else squareCorner,
      bottomEnd = if (isLastItem) groupShape.bottomEnd else squareCorner,
    )

  Surface(
    modifier =
      modifier
        .fillMaxWidth()
        .tvFocusHighlight(shape, enabled = enabled, focusedScale = 1.01f)
        .clip(shape)
        .clickable(
          enabled = enabled,
          onClick = onClick,
          interactionSource = remember { MutableInteractionSource() },
          indication = LocalIndication.current,
        ),
    shape = shape,
    color = MaterialTheme.colorScheme.surfaceContainerLow,
  ) {
    Row(
      modifier =
        Modifier
          .fillMaxWidth()
          .heightIn(min = 64.dp)
          .padding(horizontal = MaterialTheme.spacing.medium, vertical = MaterialTheme.spacing.smaller),
      verticalAlignment = Alignment.CenterVertically,
    ) {
      if (icon != null) {
        Icon(
          imageVector = icon,
          contentDescription = null,
          modifier = Modifier.size(24.dp),
          tint = MaterialTheme.colorScheme.onSurfaceVariant,
        )
        Spacer(modifier = Modifier.width(16.dp))
      }

      Column(modifier = Modifier.weight(1f)) {
        Text(
          text = title,
          style = MaterialTheme.typography.bodyLargeEmphasized,
          color = MaterialTheme.colorScheme.onSurface,
          maxLines = 2,
          overflow = TextOverflow.Ellipsis,
        )
        if (description != null) {
          Text(
            text = description,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
          )
        }
      }

      if (trailing != null) {
        Spacer(modifier = Modifier.width(8.dp))
        trailing()
      }
    }
  }
}

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun SettingsSectionHeader(
  title: String,
  modifier: Modifier = Modifier,
) {
  Text(
    text = title,
    modifier = modifier.padding(start = 16.dp, top = 24.dp, bottom = 8.dp).semantics { heading() },
    color = MaterialTheme.colorScheme.primary,
    style = MaterialTheme.typography.labelLargeEmphasized,
  )
}

@Composable
fun SettingsSwitchItem(
  title: String,
  modifier: Modifier = Modifier,
  description: String? = null,
  icon: AppIcon? = null,
  isChecked: Boolean,
  enabled: Boolean = true,
  onClick: () -> Unit,
  isFirstItem: Boolean = false,
  isLastItem: Boolean = false,
) {
  SettingsClickableItem(
    title = title,
    description = description,
    icon = icon,
    enabled = enabled,
    onClick = onClick,
    isFirstItem = isFirstItem,
    isLastItem = isLastItem,
    modifier = modifier.semantics {
      role = Role.Switch
      toggleableState = if (isChecked) ToggleableState.On else ToggleableState.Off
    },
    trailing = {
      IconSwitch(
        checked = isChecked,
        onCheckedChange = null,
        enabled = enabled,
      )
    },
  )
}

@Composable
fun SettingsDivider(modifier: Modifier = Modifier) {
  HorizontalDivider(
    modifier = modifier.padding(horizontal = 16.dp),
    color = MaterialTheme.colorScheme.outlineVariant,
  )
}

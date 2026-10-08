/*
 * SPDX-License-Identifier: AGPL-3.0-or-later
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published
 * by the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 */

package app.gyrolet.mpvrx.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialogDefaults
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.heading
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import app.gyrolet.mpvrx.R
import app.gyrolet.mpvrx.ui.player.controls.components.rememberTvInitialFocusRequester
import app.gyrolet.mpvrx.ui.player.controls.components.tvFocusGroup
import app.gyrolet.mpvrx.ui.player.controls.components.tvFocusHighlight
import app.gyrolet.mpvrx.ui.player.controls.components.tvInitialFocus
import app.gyrolet.mpvrx.ui.theme.spacing

@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun ConfirmDialog(
  title: String,
  subtitle: String,
  onConfirm: () -> Unit,
  onCancel: () -> Unit,
  modifier: Modifier = Modifier,
  customContent: (@Composable () -> Unit)? = null,
) {
  val initialFocusRequester = rememberTvInitialFocusRequester(requestKey = title)
  BasicAlertDialog(
    onCancel,
    modifier = modifier,
  ) {
    Surface(
      shape = MaterialTheme.shapes.extraLarge,
      color = AlertDialogDefaults.containerColor,
      tonalElevation = AlertDialogDefaults.TonalElevation,
    ) {
      Column(
        modifier = Modifier.padding(MaterialTheme.spacing.large),
        verticalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.large),
      ) {
        Text(
          title,
          style = MaterialTheme.typography.headlineSmallEmphasized,
          color = AlertDialogDefaults.titleContentColor,
          modifier = Modifier.semantics { heading() },
        )
        Column(
          modifier = Modifier.weight(1f, fill = false).verticalScroll(rememberScrollState()),
          verticalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.medium),
        ) {
          Text(
            subtitle,
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.Medium,
            color = AlertDialogDefaults.textContentColor,
          )
          if (customContent != null) {
            customContent()
          }
        }
        FlowRow(
          Modifier.fillMaxWidth().tvFocusGroup(),
          horizontalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.smaller, Alignment.End),
          verticalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.smaller),
        ) {
          TextButton(
            onCancel,
            shapes = ButtonDefaults.shapes(),
            modifier =
              Modifier
                .tvInitialFocus(initialFocusRequester)
                .tvFocusHighlight(MaterialTheme.shapes.extraLarge, focusedScale = 1.04f),
          ) {
            Text(
              stringResource(R.string.generic_cancel),
              fontWeight = FontWeight.Medium,
            )
          }
          TextButton(
            onConfirm,
            shapes = ButtonDefaults.shapes(),
            modifier = Modifier.tvFocusHighlight(MaterialTheme.shapes.extraLarge, focusedScale = 1.04f),
          ) {
            Text(
              stringResource(R.string.generic_confirm),
              fontWeight = FontWeight.Bold,
            )
          }
        }
      }
    }
  }
}

package com.f98k.tipstermindcocoapods.ui.screen.bottomsheet

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.RadioButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import com.f98k.tipstermindcocoapods.commons.AppThemeType
import com.f98k.tipstermindcocoapods.commons.LocalizedStrings
import com.f98k.tipstermindcocoapods.domain.bridge.VibrationBridge
import com.f98k.tipstermindcocoapods.domain.bridge.getImageResource
import com.f98k.tipstermindcocoapods.ui.components.TipsterText
import com.f98k.tipstermindcocoapods.ui.theme.TipsterTextTypeEnum

@Composable
fun ThemePickerSheet(
    currentTheme: AppThemeType,
    onThemeSelected: (AppThemeType) -> Unit,
    onDismiss: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(24.dp)
            .animateContentSize()
    ) {
        TipsterText(
            text = LocalizedStrings.selectThemeTitle(),
            type = TipsterTextTypeEnum.Subtitle,
            modifier = Modifier
                .padding(bottom = 16.dp)
                .align(Alignment.CenterHorizontally)
        )

        listOf(AppThemeType.SYSTEM, AppThemeType.LIGHT, AppThemeType.DARK).forEachIndexed { index, theme ->
            val isSelected = theme == currentTheme

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable(enabled = !isSelected) {
                        VibrationBridge.vibrate()
                        onThemeSelected(theme)
                    }
                    .padding(vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = isSelected,
                    onClick = null
                )

                Spacer(modifier = Modifier.width(12.dp))

                TipsterText(
                    text = when (theme) {
                        AppThemeType.SYSTEM -> LocalizedStrings.themeSystem()
                        AppThemeType.LIGHT -> LocalizedStrings.themeLight()
                        AppThemeType.DARK -> LocalizedStrings.themeDark()
                    },
                    type = TipsterTextTypeEnum.Body,
                    modifier = Modifier.graphicsLayer {
                        alpha = if (isSelected) 0.5f else 1f
                    }
                )
            }

            if (index < 2) {
                Divider(modifier = Modifier.padding(horizontal = 8.dp))
            }
        }

        Spacer(modifier = Modifier.height(28.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { onDismiss() }
                .padding(vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                painter = getImageResource("ic_close"),
                contentDescription = LocalizedStrings.close(),
                modifier = Modifier.size(20.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            TipsterText(
                text = LocalizedStrings.close(),
                type = TipsterTextTypeEnum.Subtitle,
            )
        }
    }
}

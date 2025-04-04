package com.f98k.tipstermindcocoapods.ui.screen.bottomsheet

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Slider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.f98k.tipstermindcocoapods.commons.LocalizedStrings
import com.f98k.tipstermindcocoapods.domain.bridge.getImageResource
import com.f98k.tipstermindcocoapods.ui.components.TipsterText
import com.f98k.tipstermindcocoapods.ui.theme.FontSizeLevel
import com.f98k.tipstermindcocoapods.ui.theme.TipsterTextTypeEnum
import androidx.compose.ui.draw.alpha

@Composable
fun FontSizePickerSheet(
    currentLevel: FontSizeLevel,
    onLevelSelected: (FontSizeLevel) -> Unit,
    onDismiss: () -> Unit
) {
    val allLevels = FontSizeLevel.entries.toTypedArray()
    val currentIndex = allLevels.indexOf(currentLevel)

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(24.dp)
    ) {
        TipsterText(
            text = LocalizedStrings.selectFontSizeTitle(),
            type = TipsterTextTypeEnum.Subtitle,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(24.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {
            TipsterText(
                text = "Aa",
                type = TipsterTextTypeEnum.Caption,
                modifier = Modifier.alpha(0.6f)
            )

            Spacer(modifier = Modifier.width(12.dp))

            Slider(
                value = currentIndex.toFloat(),
                onValueChange = {
                    onLevelSelected(allLevels[it.toInt()])
                },
                valueRange = 0f..(allLevels.size - 1).toFloat(),
                steps = allLevels.size - 2,
                modifier = Modifier.weight(1f)
            )

            Spacer(modifier = Modifier.width(12.dp))

            TipsterText(
                text = "Aa",
                type = TipsterTextTypeEnum.Title,
                modifier = Modifier.alpha(1f)
            )
        }

        Spacer(modifier = Modifier.height(28.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { onDismiss() },
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
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

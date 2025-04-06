package com.f98k.baseproject.ui.screen.bottomsheet

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Slider
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.f98k.baseproject.commons.LocalizedStrings
import com.f98k.baseproject.domain.bridge.getLexendFont
import com.f98k.baseproject.ui.components.TipsterIcon
import com.f98k.baseproject.ui.components.TipsterText
import com.f98k.baseproject.ui.theme.FontSizeLevel
import com.f98k.baseproject.ui.theme.TipsterTextTypeEnum
import kotlin.math.roundToInt

@Composable
fun FontSizePickerSheet(
    currentLevel: FontSizeLevel,
    onLevelSelected: (FontSizeLevel) -> Unit,
    onDismiss: () -> Unit
) {
    val allLevels = FontSizeLevel.entries.toTypedArray()
    var selectedIndex by remember { mutableStateOf(allLevels.indexOf(currentLevel)) }

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

        val previewFontSize = (TipsterTextTypeEnum.Body.fontSize.value * allLevels[selectedIndex].scale).sp
        Text(
            text = LocalizedStrings.previewTextSample(),
            fontSize = previewFontSize,
            fontWeight = TipsterTextTypeEnum.Body.fontWeight,
            lineHeight = TipsterTextTypeEnum.Body.lineHeight,
            fontFamily = getLexendFont(TipsterTextTypeEnum.Body.fontWeight),
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {
            TipsterText(
                text = "Aa",
                type = TipsterTextTypeEnum.Caption,
                modifier = Modifier.alpha(0.6f)
            )

            Spacer(modifier = Modifier.width(12.dp))

            Slider(
                value = selectedIndex.toFloat(),
                onValueChange = {
                    selectedIndex = it.roundToInt().coerceIn(0, allLevels.lastIndex)
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
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            TextButton(onClick = onDismiss) {
                TipsterIcon(
                    "ic_close",
                    contentDescription = LocalizedStrings.close(),
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                TipsterText(
                    text = LocalizedStrings.close(),
                    type = TipsterTextTypeEnum.Subtitle,
                )
            }

            TextButton(onClick = {
                onLevelSelected(allLevels[selectedIndex])
                onDismiss()
            }) {
                TipsterIcon(
                    "ic_confirm",
                    contentDescription = LocalizedStrings.confirm(),
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                TipsterText(
                    text = LocalizedStrings.confirm(),
                    type = TipsterTextTypeEnum.Subtitle,
                )
            }
        }
    }
}

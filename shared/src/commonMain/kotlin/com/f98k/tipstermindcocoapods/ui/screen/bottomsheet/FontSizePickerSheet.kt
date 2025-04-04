package com.f98k.tipstermindcocoapods.ui.screen.bottomsheet

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Slider
import androidx.compose.material.TextButton
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.f98k.tipstermindcocoapods.commons.LocalizedStrings
import com.f98k.tipstermindcocoapods.domain.bridge.getImageResource
import com.f98k.tipstermindcocoapods.ui.components.TipsterText
import com.f98k.tipstermindcocoapods.ui.theme.FontSizeLevel
import com.f98k.tipstermindcocoapods.ui.theme.TipsterTextTypeEnum
import com.f98k.tipstermindcocoapods.domain.bridge.getLexendFont
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
                Icon(
                    painter = getImageResource("ic_close"),
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
                Icon(
                    painter = getImageResource("ic_confirm"),
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

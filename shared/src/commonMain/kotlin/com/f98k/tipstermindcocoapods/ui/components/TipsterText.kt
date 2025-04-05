package com.f98k.tipstermindcocoapods.ui.components

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.isUnspecified
import androidx.compose.ui.unit.sp
import com.f98k.tipstermindcocoapods.domain.bridge.getLexendFont
import com.f98k.tipstermindcocoapods.domain.helper.FontSizeController
import com.f98k.tipstermindcocoapods.domain.helper.getDefaultColor
import com.f98k.tipstermindcocoapods.ui.theme.TipsterTextTypeEnum

@Composable
fun TipsterText(
    text: String,
    type: TipsterTextTypeEnum,
    modifier: Modifier = Modifier,
    color: Color? = null,
    textAlign: TextAlign? = null,
    style: TextStyle = TextStyle.Default,
    singleLine: Boolean = false,
    fontSizeScale: Float? = null
) {
    val currentFontSizeLevel = FontSizeController.currentSize.collectAsState().value
    val scale = fontSizeScale ?: currentFontSizeLevel.scale

    BoxWithConstraints(modifier = modifier) {
        val boxWidth = maxWidth
        val minFontSize = 10.sp
        val maxFontSize = 26.sp
        val baseFontSize = (type.fontSize.value * scale).sp

        val finalFontSize: TextUnit = remember(text, boxWidth, scale, type, singleLine) {
            if (!singleLine) {
                baseFontSize.coerceIn(minFontSize, maxFontSize)
            } else {
                val estimatedTextWidth = text.length * (baseFontSize.value / 2.2f)
                val adjustedSize = if (estimatedTextWidth > boxWidth.value) {
                    val adjustment = boxWidth.value / estimatedTextWidth
                    (baseFontSize.value * adjustment).sp
                } else baseFontSize

                adjustedSize.coerceIn(minFontSize, maxFontSize)
            }
        }
        val adjustedLineHeight = (type.lineHeight.value * scale).sp

        BasicText(
            text = text,
            maxLines = if (singleLine) 1 else Int.MAX_VALUE,
            style = style.merge(
                TextStyle(
                    fontSize = finalFontSize,
                    fontWeight = type.fontWeight,
                    color = color ?: getDefaultColor(),
                    textAlign = textAlign ?: TextAlign.Start,
                    lineHeight = adjustedLineHeight,
                    fontFamily = getLexendFont(type.fontWeight)
                )
            )
        )
    }
}



private fun TextUnit.coerceIn(min: TextUnit, max: TextUnit): TextUnit {
    if (this.isUnspecified) return this
    return when {
        this < min -> min
        this > max -> max
        else -> this
    }
}

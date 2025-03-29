package com.f98k.tipstermindcocoapods.ui.components

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.f98k.tipstermindcocoapods.domain.bridge.getLexendFont
import com.f98k.tipstermindcocoapods.ui.theme.TipsterTextTypeEnum

@Composable
fun TipsterText(
    text: String,
    type: TipsterTextTypeEnum,
    modifier: Modifier = Modifier,
    color: Color? = null,
    textAlign: TextAlign? = null,
    style: TextStyle = TextStyle.Default,
    singleLine: Boolean = false
) {
    BoxWithConstraints(modifier = modifier) {
        val boxWidth = maxWidth
        val maxFontSize = type.fontSize
        val minFontSize = 8.sp

        val finalFontSize = remember(text, boxWidth, singleLine, type) {
            if (!singleLine) {
                type.fontSize
            } else {
                val lengthFactor = text.length / 10f
                val scaleFactor = 1f / lengthFactor.coerceAtLeast(1f)
                (maxFontSize.value * scaleFactor)
                    .coerceAtLeast(minFontSize.value)
                    .sp
            }
        }

        BasicText(
            text = text,
            maxLines = if (singleLine) 1 else Int.MAX_VALUE,
            style = style.merge(
                TextStyle(
                    fontSize = finalFontSize,
                    fontWeight = type.fontWeight,
                    color = color ?: if(isSystemInDarkTheme()) Color.White else Color.Black,
                    textAlign = textAlign ?: TextAlign.Start,
                    lineHeight = type.lineHeight,
                    fontFamily = getLexendFont(type.fontWeight)
                )
            )
        )
    }
}

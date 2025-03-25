package com.f98k.tipstermindcocoapods.ui.components

import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import com.f98k.tipstermindcocoapods.data.constants.TipsterTextTypeEnum
import com.f98k.tipstermindcocoapods.domain.bridge.getLexendFont

@Composable
fun TipsterText(
    text: String,
    modifier: Modifier = Modifier,
    type: TipsterTextTypeEnum = TipsterTextTypeEnum.Body,
    color: Color = Color.Black,
    textAlign: TextAlign? = null,
    fontSize: TextUnit = type.fontSize,
    fontWeight: FontWeight = type.fontWeight,
    lineHeight: TextUnit = type.lineHeight,
    style: TextStyle = TextStyle.Default
) {
    BasicText(
        text = text,
        modifier = modifier,
        style = style.merge(
            TextStyle(
                fontSize = fontSize,
                fontWeight = fontWeight,
                color = color,
                textAlign = textAlign?: TextAlign.Start,
                lineHeight = lineHeight,
                fontFamily = getLexendFont(fontWeight)
            )
        )
    )
}
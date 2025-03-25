package com.f98k.tipstermindcocoapods.data.constants

import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

enum class TipsterTextTypeEnum(
    val fontSize: TextUnit,
    val lineHeight: TextUnit,
    val fontWeight: FontWeight
) {
    Title(fontSize = 22.sp, lineHeight = 28.sp, fontWeight = FontWeight.Bold),
    Subtitle(fontSize = 18.sp, lineHeight = 23.sp, fontWeight = FontWeight.Bold),
    Body(fontSize = 16.sp, lineHeight = 24.sp, fontWeight = FontWeight.Normal)
}
package com.f98k.tipstermindcocoapods.ui.theme

import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.f98k.tipstermindcocoapods.domain.helper.FontSizeController

enum class TipsterTextTypeEnum(
    val fontSize: TextUnit,
    val fontWeight: FontWeight,
    val lineHeight: TextUnit
) {
    Title(fontSize = 20.sp, fontWeight = FontWeight.Bold, lineHeight = 28.sp),
    Subtitle(fontSize = 16.sp, fontWeight = FontWeight.Medium, lineHeight = 24.sp),
    Body(fontSize = 14.sp, fontWeight = FontWeight.Normal, lineHeight = 20.sp),
    Caption(fontSize = 12.sp, fontWeight = FontWeight.Light, lineHeight = 16.sp)
}

enum class FontSizeLevel(val scale: Float) {
    SMALL(0.85f),
    NORMAL(1.0f),
    EXTRA_LARGE(1.5f),
    EXTRA_HUGE(2f),
    EXTRA_MAX_SIZE(2.2f),
}
fun TipsterTextTypeEnum.scaledFontSize(): TextUnit {
    val scale = FontSizeController.currentSize.value.scale
    return (fontSize.value * scale).sp
}
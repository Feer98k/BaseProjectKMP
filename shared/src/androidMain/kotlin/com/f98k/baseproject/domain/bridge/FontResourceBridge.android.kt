package com.f98k.baseproject.domain.bridge

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.f98k.baseproject.R

private val LexendRegular = FontFamily(Font(R.font.lexend_regular, FontWeight.Normal))
private val LexendMedium = FontFamily(Font(R.font.lexend_medium, FontWeight.Medium))
private val LexendBold = FontFamily(Font(R.font.lexend_bold, FontWeight.Bold))

actual fun getLexendFont(weight: FontWeight): FontFamily {
    return when (weight) {
        FontWeight.Normal -> LexendRegular
        FontWeight.Medium -> LexendMedium
        FontWeight.Bold -> LexendBold
        else -> LexendRegular // fallback
    }
}
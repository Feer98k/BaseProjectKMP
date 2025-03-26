package com.f98k.tipstermindcocoapods.domain.bridge

import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight


actual fun getLexendFont(weight: FontWeight): FontFamily {
    return when (weight) {
        FontWeight.Bold,
        FontWeight.SemiBold,
        FontWeight.Medium -> FontFamily.SansSerif

        FontWeight.Normal,
        FontWeight.Light,
        FontWeight.Thin -> FontFamily.Default

        else -> FontFamily.Default
    }
}
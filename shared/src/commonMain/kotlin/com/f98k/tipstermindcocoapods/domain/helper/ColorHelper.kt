package com.f98k.tipstermindcocoapods.domain.helper

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.graphics.Color
import com.f98k.tipstermindcocoapods.commons.AppThemeController
import com.f98k.tipstermindcocoapods.commons.AppThemeType

@Composable
fun getDefaultColor(): Color {
    val theme = AppThemeController.currentTheme.collectAsState().value
    return when {
        theme == AppThemeType.DARK || (theme == AppThemeType.SYSTEM && isSystemInDarkTheme()) -> Color.White
        else -> Color.DarkGray
    }
}

@Composable
fun setColorByTheme(lightColor: Color, darkColor: Color) : Color {
    val theme = AppThemeController.currentTheme.collectAsState().value
    return when {
        theme == AppThemeType.DARK || (theme == AppThemeType.SYSTEM && isSystemInDarkTheme()) -> lightColor
        else -> darkColor
    }
}
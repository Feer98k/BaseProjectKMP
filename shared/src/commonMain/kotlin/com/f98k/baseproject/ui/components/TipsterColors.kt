package com.f98k.baseproject.ui.components

import androidx.compose.ui.graphics.Color

object TipsterColors {

    // Primary brand color (used for buttons, highlights)
    val PrimaryBlue = Color(0xFF3A5EFF)

    // Darker shade of the brand color (used for pressed states)
    val PrimaryBlueDark = Color(0xFF2A4ED8)

    // Secondary accent (used for supportive highlights, tabs, etc)
    val AccentSky = Color(0xFF94ADC7)

    // Background for dark theme
    val BackgroundDark = Color(0xFF000000)

    // Background for light theme
    val BackgroundLight = Color(0xFFFFFFFF)

    // Surface color for cards and sheets (dark mode)
    val SurfaceDark = Color(0xFF1B1B1B)

    // Surface color for cards and sheets (light mode)
    val SurfaceLight = Color(0xFFF2F2F2)

    // Default text color on dark backgrounds
    val TextLight = Color.White

    // Default text color on light backgrounds
    val TextDark = Color.Black

    // Neutral border or line divider
    val DividerGray = Color(0xFFCCCCCC)

    // Success green (e.g. correct result, confirmations)
    val SuccessGreen = Color(0xFF4CAF50)

    // Error red (e.g. failed predictions, alerts)
    val ErrorRed = Color(0xFFF44336)

    // Warning or attention yellow
    val WarningYellow = Color(0xFFFFC107)

    // Info blue (for tips or guidance)
    val InfoBlue = Color(0xFF2196F3)

    // Overlay scrim (e.g. modal background)
    val ScrimBlackAlpha = Color(0x80000000) // 50% opacity
}
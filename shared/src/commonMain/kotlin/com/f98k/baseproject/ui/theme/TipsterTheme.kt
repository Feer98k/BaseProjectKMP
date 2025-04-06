package com.f98k.baseproject.ui.theme


import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Shapes
import androidx.compose.material.Typography
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.f98k.baseproject.commons.AppThemeController
import com.f98k.baseproject.commons.AppThemeType
import com.f98k.baseproject.domain.bridge.getLexendFont


private val TipsterDarkColors = darkColors(
    primary = Color(0xFF3A5EFF),
    primaryVariant = Color(0xFF2A4ED8),
    secondary = Color(0xFF788D9C),
    background = Color(0xFF0D0D0D),
    surface = Color(0xFF1B1B1B),
    onPrimary = Color.White,
    onSecondary = Color(0xFFB0BEC5),
    onBackground = Color.White,
    onSurface = Color(0xFFE0E0E0)
)

private val TipsterLightColors = lightColors(
    primary = Color(0xFF3A5EFF),
    primaryVariant = Color(0xFF2A4ED8),
    secondary = Color(0xFF5A6D80),
    background = Color(0xFFFFFFFF),
    surface = Color(0xFFEFEFEF),
    onPrimary = Color.White,
    onSecondary = Color(0xFF37474F),
    onBackground = Color.Black,
    onSurface = Color(0xFF212121)
)

private val TipsterTypography = Typography(
    h4 = TextStyle(
        fontFamily = getLexendFont(FontWeight.Bold),
        fontSize = 22.sp,
        lineHeight = 28.sp,
        fontWeight = FontWeight.Bold,
    ),
    h5 = TextStyle(
        fontFamily = getLexendFont(FontWeight.Medium),
        fontSize = 18.sp,
        lineHeight = 24.sp,
        fontWeight = FontWeight.Medium
    ),
    body1 = TextStyle(
        fontFamily = getLexendFont(FontWeight.Normal),
        fontSize = 16.sp,
        lineHeight = 24.sp
    ),
    body2 = TextStyle(
        fontFamily = getLexendFont(FontWeight.Normal),
        fontSize = 14.sp,
        lineHeight = 21.sp
    ),
    caption = TextStyle(
        fontFamily = getLexendFont(FontWeight.Light),
        fontSize = 12.sp
    )
)



private val TipsterShapes = Shapes(
    small = RoundedCornerShape(8.dp),
    medium = RoundedCornerShape(12.dp),
    large = RoundedCornerShape(20.dp)
)


@Composable
fun TipsterTheme(
    theme: AppThemeType = AppThemeController.currentTheme.collectAsState().value,
    content: @Composable () -> Unit
) {
    val isDarkTheme = when (theme) {
        AppThemeType.SYSTEM -> isSystemInDarkTheme()
        AppThemeType.DARK -> true
        AppThemeType.LIGHT -> false
    }

    val colors = if (isDarkTheme) TipsterDarkColors else TipsterLightColors

    MaterialTheme(
        colors = colors,
        typography = TipsterTypography,
        shapes = TipsterShapes,
        content = content
    )
}
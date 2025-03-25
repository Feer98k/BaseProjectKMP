package com.f98k.tipstermindcocoapods.ui.theme


import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Shapes
import androidx.compose.material.Typography
import androidx.compose.ui.text.font.FontWeight
import com.f98k.tipstermindcocoapods.domain.bridge.getLexendFont


private val TipsterDarkColors = darkColors(
    primary = Color(0xFF3A5EFF),
    primaryVariant = Color(0xFF2A4ED8),
    secondary = Color(0xFF94ADC7),
    background = Color(0xFF000000),
    surface = Color(0xFF1B1B1B),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onBackground = Color.White,
    onSurface = Color.White
)

private val TipsterTypography = Typography(
    h4 = TextStyle(
        fontFamily = getLexendFont(FontWeight.Bold),
        fontSize = 22.sp,
        lineHeight = 28.sp,
        fontWeight = FontWeight.Bold
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
fun TipsterTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colors = TipsterDarkColors,
        typography = TipsterTypography,
        shapes = TipsterShapes,
        content = content
    )
}
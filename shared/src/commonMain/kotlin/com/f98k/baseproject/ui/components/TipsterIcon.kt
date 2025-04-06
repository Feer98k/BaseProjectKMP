package com.f98k.baseproject.ui.components

import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.f98k.baseproject.domain.bridge.getImageResource
import com.f98k.baseproject.domain.helper.FontSizeController
import com.f98k.baseproject.domain.helper.getDefaultColor


@Composable
fun TipsterIcon(
    iconName: String,
    contentDescription: String,
    modifier: Modifier = Modifier,
    tint: Color? = null,
    baseSize: Dp = 24.dp
) {
    val currentScale = FontSizeController.currentSize.collectAsState().value.scale
    val scaledSize = (baseSize.value * currentScale).dp

    Icon(
        painter = getImageResource(iconName),
        contentDescription = contentDescription,
        tint = tint ?: getDefaultColor(),
        modifier = modifier.size(scaledSize)
    )
}
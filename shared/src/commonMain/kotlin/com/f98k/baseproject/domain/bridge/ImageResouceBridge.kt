package com.f98k.baseproject.domain.bridge

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter


@Composable
expect fun getImageResource(name: String): Painter
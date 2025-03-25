package com.f98k.tipstermindcocoapods.domain.bridge

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import com.f98k.tipstermindcocoapods.R

@Composable
actual fun getImageResource(name: String): Painter {
    return when (name) {
        "ic_back_left" -> painterResource(R.drawable.baseline_arrow_back)
        else -> painterResource(R.drawable.baseline_arrow_back)
    }
}
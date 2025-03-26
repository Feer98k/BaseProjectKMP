package com.f98k.tipstermindcocoapods.domain.bridge

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import com.f98k.tipstermindcocoapods.R

@Composable
actual fun getImageResource(name: String): Painter {
    return when (name) {
        "ic_back_left" -> painterResource(R.drawable.baseline_arrow_back)
        "ic_bottom_bar_favorites" -> painterResource(R.drawable.ic_bottom_bar_favorites)
        "ic_bottom_bar_home" -> painterResource(R.drawable.ic_bottom_bar_home)
        "ic_bottom_bar_ia" -> painterResource(R.drawable.ic_bottom_bar_ia)
        "ic_bottom_bar_search" -> painterResource(R.drawable.ic_bottom_bar_search)
        "ic_bottom_bar_settings" -> painterResource(R.drawable.ic_bottom_bar_settings)
        else -> painterResource(R.drawable.baseline_arrow_back)
    }
}
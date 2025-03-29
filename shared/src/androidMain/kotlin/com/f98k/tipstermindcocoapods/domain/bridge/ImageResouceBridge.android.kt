package com.f98k.tipstermindcocoapods.domain.bridge

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import com.f98k.tipstermindcocoapods.R

@Composable
actual fun getImageResource(name: String): Painter {
    val context = LocalContext.current
    val resourceId = remember(name) {
        context.resources.getIdentifier(name, "drawable", context.packageName)
    }

    return if (resourceId != 0) {
        painterResource(id = resourceId)
    } else {
        painterResource(id = R.drawable.ic_bottom_bar_settings)
    }
}
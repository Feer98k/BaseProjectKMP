package com.f98k.baseproject

import androidx.compose.ui.window.ComposeUIViewController
import com.f98k.baseproject.domain.di.initKoin
import com.f98k.baseproject.ui.navigation.composable.MainScreen
import com.f98k.baseproject.ui.theme.TipsterTheme


fun MainViewController() = ComposeUIViewController(
    configure = {
        initKoin()
    }
) {
    TipsterTheme {
        MainScreen()
    }
}


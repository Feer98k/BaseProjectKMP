package com.f98k.tipstermindcocoapods

import androidx.compose.ui.window.ComposeUIViewController
import com.f98k.tipstermindcocoapods.domain.di.initKoin
import com.f98k.tipstermindcocoapods.ui.navigation.composable.home.HomeScreen
import com.f98k.tipstermindcocoapods.ui.theme.TipsterTheme


fun MainViewController() = ComposeUIViewController(
    configure = {
        initKoin()
    }
) {
    TipsterTheme {
        HomeScreen()
    }
}


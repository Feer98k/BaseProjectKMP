package com.f98k.tipstermindcocoapods

import androidx.compose.runtime.collectAsState
import androidx.compose.ui.window.ComposeUIViewController
import com.f98k.tipstermindcocoapods.domain.di.initKoin
import com.f98k.tipstermindcocoapods.ui.HomeScreenApp
import com.f98k.tipstermindcocoapods.ui.screen.home.viewmodel.HomeViewModel
import com.f98k.tipstermindcocoapods.ui.theme.TipsterTheme
import org.koin.compose.koinInject


fun MainViewController() = ComposeUIViewController(
    configure = {
        initKoin()
    }
) {
    val viewModel = koinInject<HomeViewModel>()
    TipsterTheme {
        HomeScreenApp(
            uiState = viewModel.uiState.collectAsState().value,
            uiStateActions = viewModel.actions
        )
    }
}


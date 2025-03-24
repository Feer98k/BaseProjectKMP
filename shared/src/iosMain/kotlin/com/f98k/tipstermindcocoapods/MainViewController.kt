package com.f98k.tipstermindcocoapods

import androidx.compose.ui.window.ComposeUIViewController
import com.f98k.tipstermindcocoapods.domain.di.initKoin
import com.f98k.tipstermindcocoapods.ui.presentation.HomeScreenApp
import com.f98k.tipstermindcocoapods.ui.viewmodel.HomeViewModel
import org.koin.compose.koinInject
import androidx.compose.runtime.collectAsState


fun MainViewController() = ComposeUIViewController(
    configure = {
        initKoin()
    }
) {
    val viewModel = koinInject<HomeViewModel>()
    HomeScreenApp(
        uiState = viewModel.uiState.collectAsState().value,
    )
}


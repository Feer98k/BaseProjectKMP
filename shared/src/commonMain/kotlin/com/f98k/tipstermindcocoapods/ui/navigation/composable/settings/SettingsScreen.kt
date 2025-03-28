package com.f98k.tipstermindcocoapods.ui.navigation.composable.settings

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import com.f98k.tipstermindcocoapods.ui.screen.settings.screen.SettingsScreenContent
import com.f98k.tipstermindcocoapods.ui.screen.settings.viewmodel.SettingsViewModel
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.annotation.KoinExperimentalAPI

@OptIn(KoinExperimentalAPI::class)
@Composable
fun SettingsScreen() {
    val viewModel = koinViewModel<SettingsViewModel>()
    val uiState = viewModel.uiState.collectAsState().value
    val uiStateActions = viewModel.uiStateActions

    SettingsScreenContent(
        uiState = uiState,
        uiStateActions = uiStateActions
    )
}
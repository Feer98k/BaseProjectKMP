package com.f98k.tipstermindcocoapods.ui.navigation.composable.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import com.f98k.tipstermindcocoapods.ui.screen.home.screen.HomeScreenContent
import com.f98k.tipstermindcocoapods.ui.screen.home.viewmodel.HomeViewModel
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.annotation.KoinExperimentalAPI

@OptIn(KoinExperimentalAPI::class)
@Composable
fun HomeScreen() {
    val viewModel = koinViewModel<HomeViewModel>()
    val uiState = viewModel.uiState.collectAsState().value
    val uiStateActions = viewModel.uiActions

    HomeScreenContent(
        uiState = uiState,
        uiStateAction = uiStateActions
    )
}


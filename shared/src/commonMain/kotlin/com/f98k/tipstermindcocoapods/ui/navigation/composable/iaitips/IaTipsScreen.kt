package com.f98k.tipstermindcocoapods.ui.navigation.composable.iaitips

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import com.f98k.tipstermindcocoapods.ui.screen.iatips.screen.IaTipsScreenContent
import com.f98k.tipstermindcocoapods.ui.screen.iatips.viewmodel.IaTipsViewModel
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.annotation.KoinExperimentalAPI

@OptIn(KoinExperimentalAPI::class)
@Composable
fun IaTipsScreen() {
    val viewModel = koinViewModel<IaTipsViewModel>()
    val uiState = viewModel.uiState.collectAsState().value
    val uiStateActions = viewModel.uiStateActions

    IaTipsScreenContent(
        uiState = uiState,
        uiStateActions = uiStateActions
    )
}
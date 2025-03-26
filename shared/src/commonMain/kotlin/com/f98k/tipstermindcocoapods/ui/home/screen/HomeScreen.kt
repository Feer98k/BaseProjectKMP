package com.f98k.tipstermindcocoapods.ui.home.screen

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import com.f98k.tipstermindcocoapods.commons.StringConstants
import com.f98k.tipstermindcocoapods.ui.components.TipsterTopBar
import com.f98k.tipstermindcocoapods.ui.home.state.HomeUiActions
import com.f98k.tipstermindcocoapods.ui.home.state.HomeUiState

@Composable
fun HomeScreenApp(
    uiState: HomeUiState,
    uiStateActions: HomeUiActions
) {
    Scaffold(
        topBar = {
            TipsterTopBar(
                title = StringConstants.APP_NAME,
                showBackButton = true
            )
        },
        content = {
            HomeScreenContent(
                uiState = uiState,
                uiStateAction = uiStateActions
            )
        })
}


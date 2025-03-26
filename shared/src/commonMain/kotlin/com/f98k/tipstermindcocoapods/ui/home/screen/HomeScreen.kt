package com.f98k.tipstermindcocoapods.ui.home.screen

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import com.f98k.tipstermindcocoapods.commons.StringConstants
import com.f98k.tipstermindcocoapods.navigation.TipsterRouters
import com.f98k.tipstermindcocoapods.ui.components.TipsterBottomBar
import com.f98k.tipstermindcocoapods.ui.components.TipsterTopBar
import com.f98k.tipstermindcocoapods.ui.home.state.HomeUiActions
import com.f98k.tipstermindcocoapods.ui.home.state.HomeUiState
import androidx.compose.runtime.LaunchedEffect

@Composable
fun HomeScreenApp(
    uiState: HomeUiState,
    uiStateActions: HomeUiActions
) {
    LaunchedEffect(Unit) {
        uiStateActions.getBottomBarList()
        uiStateActions.getRemoteConfigData()
    }
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
        },
        bottomBar = {
            TipsterBottomBar(
                items = uiState.bottomBarList.bottomBarList,
                currentAction = TipsterRouters.HOME,
                onItemSelected = {}
            )
        }
    )
}


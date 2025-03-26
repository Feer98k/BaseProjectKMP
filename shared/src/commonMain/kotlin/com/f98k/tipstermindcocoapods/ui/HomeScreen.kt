package com.f98k.tipstermindcocoapods.ui

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.LaunchedEffect
import com.f98k.tipstermindcocoapods.commons.StringConstants
import com.f98k.tipstermindcocoapods.navigation.TipsterRouters
import com.f98k.tipstermindcocoapods.ui.components.TipsterBottomBar
import com.f98k.tipstermindcocoapods.ui.components.TipsterTopBar
import com.f98k.tipstermindcocoapods.ui.screen.home.screen.HomeScreenContent
import com.f98k.tipstermindcocoapods.ui.screen.home.state.HomeUiActions
import com.f98k.tipstermindcocoapods.ui.screen.home.state.HomeUiState

@Composable
fun HomeScreenApp(
    uiState: HomeUiState,
    uiStateActions: HomeUiActions
) {
    LaunchedEffect(Unit) {
        uiStateActions.getBottomBarList()
        uiStateActions.getRemoteConfigData()
    }
    val currentAction = remember { mutableStateOf(TipsterRouters.HOME) }
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
                currentAction = currentAction.value,
                onItemSelected = {
                    currentAction.value = it
                }
            )
        }
    )
}


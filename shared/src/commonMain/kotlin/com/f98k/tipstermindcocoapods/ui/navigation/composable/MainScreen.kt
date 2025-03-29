package com.f98k.tipstermindcocoapods.ui.navigation.composable

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.f98k.tipstermindcocoapods.ui.components.TipsterBottomBar
import com.f98k.tipstermindcocoapods.ui.navigation.AppNavGraph
import com.f98k.tipstermindcocoapods.ui.screen.main.MainViewModel
import com.f98k.tipstermindcocoapods.ui.screen.settings.component.SettingsComponent
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.annotation.KoinExperimentalAPI

@OptIn(KoinExperimentalAPI::class)
@Composable

fun MainScreen() {
    val navController = rememberNavController()

    val currentTopBar: MutableState<(@Composable () -> Unit)?> = remember { mutableStateOf(null) }
    val showBottomBar: MutableState<Boolean> = remember { mutableStateOf(true) }


    val viewModel = koinViewModel<MainViewModel>()
    val uiState = viewModel.uiState.collectAsState().value
    val uiActions = viewModel.uiActions


    LaunchedEffect(Unit) {
        uiActions.getBottomBarList()
    }

    Scaffold(
        topBar = {
            currentTopBar.value?.invoke()
        },
        bottomBar = {
            if (showBottomBar.value) TipsterBottomBar(
                navController = navController,
                items = uiState.bottomBarList.bottomBarList,
                isToShowSettingsComponent = {uiActions.setDrawerVisibility(it)}
            )
        }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            AppNavGraph(
                navController = navController,
                setTopBar = { topBarComposable -> currentTopBar.value = topBarComposable },
                setBottomBarVisibility = { show -> showBottomBar.value = show },
                closeSettingDraw = {
                    uiActions.setDrawerVisibility(false)
                },
                onSettingsClick = {
                    uiActions.setDrawerVisibility(true)
                },
            )

                SettingsComponent(
                    modifier = Modifier.fillMaxSize(),
                    isVisible = uiState.isToShowSettingsDrawer,
                    settingsItems = uiState.settingsList,
                    onItemClick = { item ->
                        //todo implementar action
                    },
                    onDismiss = {
                        navController.popBackStack()
                        uiActions.setDrawerVisibility(false)
                    }
                )

        }
    }
}
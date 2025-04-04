package com.f98k.tipstermindcocoapods.ui.navigation.composable

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.f98k.tipstermindcocoapods.domain.extensions.toModalBottomSheetType
import com.f98k.tipstermindcocoapods.ui.components.TipsterBottomBar
import com.f98k.tipstermindcocoapods.ui.components.TipsterBottomSheetContent
import com.f98k.tipstermindcocoapods.ui.navigation.AppNavGraph
import com.f98k.tipstermindcocoapods.ui.screen.main.MainUiState
import com.f98k.tipstermindcocoapods.ui.screen.main.MainUiStateAction
import com.f98k.tipstermindcocoapods.ui.screen.main.MainViewModel
import com.f98k.tipstermindcocoapods.ui.screen.settings.component.ManageSettingsClicked
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

    val scaffoldState = rememberBottomSheetScaffoldState()

    LaunchedEffect(uiState.isBottomSheetVisible) {
        if (uiState.isBottomSheetVisible) {
            scaffoldState.bottomSheetState.expand()
        } else {
            scaffoldState.bottomSheetState.collapse()
        }
    }

    LaunchedEffect(scaffoldState.bottomSheetState.currentValue) {
        if (scaffoldState.bottomSheetState.isCollapsed) {
            uiActions.hideBottomSheet()
        }
    }

    LaunchedEffect(Unit) {
        uiActions.getBottomBarList()
    }

    BottomSheetScaffold(
        scaffoldState = scaffoldState,
        sheetContent = {
            TipsterBottomSheetContent(type = uiState.currentBottomSheet, uiActions)
        },
        sheetPeekHeight = 0.dp,
        topBar = {
            currentTopBar.value?.invoke()
        }
    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            Box(modifier = Modifier.weight(1f)) {
                MainContent(
                    innerPadding,
                    navController,
                    currentTopBar,
                    showBottomBar,
                    uiActions,
                    uiState
                )
            }
            if (showBottomBar.value) TipsterBottomBar(
                navController = navController,
                items = uiState.bottomBarList.bottomBarList,
                isToShowSettingsComponent = { uiActions.setDrawerVisibility(it) }
            )
        }
    }
}

@Composable
private fun MainContent(
    innerPadding: PaddingValues,
    navController: NavHostController,
    currentTopBar: MutableState<@Composable (() -> Unit)?>,
    showBottomBar: MutableState<Boolean>,
    uiActions: MainUiStateAction,
    uiState: MainUiState,
) {
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
                uiActions.setDrawerVisibility(false)
                uiActions.showBottomSheet(item.action.toModalBottomSheetType())
            },
            onDismiss = {
                navController.popBackStack()
                uiActions.setDrawerVisibility(false)
            }
        )

        if (uiState.isToShowSettingsActionComponent) {
            ManageSettingsClicked(uiState.lastActionClicked, uiActions)
        }

    }
}

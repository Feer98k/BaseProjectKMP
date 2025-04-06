package com.f98k.baseproject.ui.navigation.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomSheetScaffold
import androidx.compose.material.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.f98k.baseproject.domain.extensions.toModalBottomSheetType
import com.f98k.baseproject.ui.components.TipsterBottomBar
import com.f98k.baseproject.ui.components.TipsterBottomSheetContent
import com.f98k.baseproject.ui.navigation.AppNavGraph
import com.f98k.baseproject.ui.screen.bottomsheet.BottomSheetHandle
import com.f98k.baseproject.ui.screen.main.MainUiState
import com.f98k.baseproject.ui.screen.main.MainUiStateAction
import com.f98k.baseproject.ui.screen.main.MainViewModel
import com.f98k.baseproject.ui.screen.settings.component.ManageSettingsClicked
import com.f98k.baseproject.ui.screen.settings.component.SettingsComponent
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
            BottomSheetHandle()
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
        if (uiState.isBottomSheetVisible) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black.copy(alpha = 0.5f))
                    .clickable {
                        uiActions.hideBottomSheet()
                    }
            )
        }

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

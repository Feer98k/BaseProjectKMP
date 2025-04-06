package com.f98k.baseproject.ui.navigation.composable.favorite

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import com.f98k.baseproject.ui.screen.favorite.screen.FavoriteScreenContent
import com.f98k.baseproject.ui.screen.favorite.viewmodel.FavoriteViewModel
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.annotation.KoinExperimentalAPI

@OptIn(KoinExperimentalAPI::class)
@Composable
fun FavoritesScreen() {
    val viewModel = koinViewModel<FavoriteViewModel>()
    val uiState = viewModel.uiState.collectAsState().value
    val uiStateActions = viewModel.uiStateActions

    FavoriteScreenContent(
        uiState = uiState,
        uiStateActions = uiStateActions
    )
}
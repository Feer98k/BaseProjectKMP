package com.f98k.baseproject.ui.navigation.composable.search

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import com.f98k.baseproject.ui.screen.search.screen.SearchScreenContent
import com.f98k.baseproject.ui.screen.search.viewmodel.SearchViewModel
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.annotation.KoinExperimentalAPI

@OptIn(KoinExperimentalAPI::class)
@Composable
fun SearchScreen() {
    val viewModel = koinViewModel<SearchViewModel>()
    val uiState = viewModel.uiState.collectAsState().value
    val uiStateActions = viewModel.uiActions

    SearchScreenContent(
        uiState = uiState,
        uiStateActions = uiStateActions
    )
}
package com.f98k.tipstermindcocoapods.ui.screen.favorite.viewmodel

import androidx.lifecycle.ViewModel
import com.f98k.tipstermindcocoapods.domain.usecase.favorite.FavoriteUseCase
import com.f98k.tipstermindcocoapods.ui.screen.favorite.state.FavoriteUiActions
import com.f98k.tipstermindcocoapods.ui.screen.favorite.state.FavoriteUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class FavoriteViewModel(private val useCase: FavoriteUseCase) : ViewModel() {

    private val _uiState: MutableStateFlow<FavoriteUiState> = MutableStateFlow(FavoriteUiState())
    val uiState: StateFlow<FavoriteUiState> get() = _uiState

    val uiStateActions: FavoriteUiActions
        get() = FavoriteUiActions()

}
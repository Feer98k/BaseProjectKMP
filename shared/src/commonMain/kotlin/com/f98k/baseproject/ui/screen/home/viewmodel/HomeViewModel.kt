package com.f98k.baseproject.ui.screen.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.f98k.baseproject.domain.usecase.home.HomeUseCase
import com.f98k.baseproject.ui.screen.home.state.HomeUiActions
import com.f98k.baseproject.ui.screen.home.state.HomeUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel(private val useCase: HomeUseCase) : ViewModel() {

    private val _uiState: MutableStateFlow<HomeUiState> = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> get() = _uiState

    init {
        fetchGeneralMatches()
    }
    val uiActions: HomeUiActions
        get() = HomeUiActions(
            getGeneralMatchList = { fetchGeneralMatches() }
        )


    private fun fetchGeneralMatches() {
        launchWithLoading(
            onSuccess = { matches ->
                _uiState.update { it.copy(generalMatchList = matches) }
            },
            block = { useCase.allLeaguesMatches() }
        )
    }


    private fun <T> launchWithLoading(
        onSuccess: (T) -> Unit,
        onError: (Throwable) -> Unit = {},
        block: suspend () -> T
    ) {
        viewModelScope.launch {
            changeLoadingState(true)
            runCatching {
                block()
            }.onSuccess { result ->
                onSuccess(result)
            }.onFailure { throwable ->
                onError(throwable)
            }
            changeLoadingState(false)
        }
    }

    private fun changeLoadingState(isLoading: Boolean) {
        _uiState.update { currentState ->
            currentState.copy(
                isToShowLoading = isLoading
            )
        }
    }
}
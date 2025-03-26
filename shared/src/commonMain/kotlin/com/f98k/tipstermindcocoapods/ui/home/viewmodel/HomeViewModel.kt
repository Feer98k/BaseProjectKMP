package com.f98k.tipstermindcocoapods.ui.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.f98k.tipstermindcocoapods.data.constants.RemoteConfigEnum
import com.f98k.tipstermindcocoapods.domain.usecase.HomeUseCase
import com.f98k.tipstermindcocoapods.ui.home.state.HomeUiActions
import com.f98k.tipstermindcocoapods.ui.home.state.HomeUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomeViewModel(private val useCase: HomeUseCase) : ViewModel() {

    private val _uiState: MutableStateFlow<HomeUiState> = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> get() = _uiState

    val actions = HomeUiActions(
        getRemoteConfigData = {
            fetchGeneralMatches()
        },
        getBottomBarList = {
            fetchBottomBarList()
        }
    )

    private fun fetchBottomBarList() {
        launchWithLoading(
            onSuccess = { bottomBar ->
                _uiState.update { it.copy(bottomBarList = bottomBar) }
            },
            block = { useCase.fetchRemoteConfigData(RemoteConfigEnum.BOTTOM_BAR_LIST) }
        )
    }

    private fun fetchGeneralMatches() {
        launchWithLoading(
            onSuccess = { matches ->
                _uiState.update { it.copy(generalMatchList = matches) }
            },
            block = { useCase.generalMatches() }
        )
    }


    private fun <T> launchWithLoading(
        onSuccess: (T) -> Unit,
        block: suspend () -> T
    ) {
        viewModelScope.launch {
            changeLoadingState(true)
            try {
                val result = block()
                onSuccess(result)
            } catch (e: Exception) {
                // doNothing
            } finally {
                changeLoadingState(false)
            }
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
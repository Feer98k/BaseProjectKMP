package com.f98k.tipstermindcocoapods.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.f98k.tipstermindcocoapods.data.constants.RemoteConfigEnum
import com.f98k.tipstermindcocoapods.data.model.ResponseResourceCallback
import com.f98k.tipstermindcocoapods.domain.usecase.HomeUseCase
import com.f98k.tipstermindcocoapods.ui.state.HomeUiActions
import com.f98k.tipstermindcocoapods.ui.state.HomeUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel(private val homeUseCase: HomeUseCase) : ViewModel() {

    private val _uiState: MutableStateFlow<HomeUiState> = MutableStateFlow(HomeUiState())
    val uiState: MutableStateFlow<HomeUiState> get() = _uiState

    val actions = HomeUiActions(
        getRemoteConfigData = {
            fetchGeneralMatches()
        }
    )

    private fun fetchGeneralMatches() {
        _uiState.update { currentState ->
            currentState.copy(
                generalMatchList = "pegando dados...",
            )
        }
        viewModelScope.launch {
            homeUseCase.fetchRemoteConfigData(RemoteConfigEnum.GENERAL_MATCHES_HML) { result ->
                when (result) {
                    is ResponseResourceCallback.Success -> {
                        _uiState.update { currentState ->
                            currentState.copy(
                                isToShowLoading = false,
                                generalMatchList = result.data.toString()
                            )
                        }
                    }

                    is ResponseResourceCallback.Error -> {
                        _uiState.update { currentState ->
                            currentState.copy(
                                isToShowLoading = false,
                                generalMatchList = "failuere"
                            )
                        }
                    }

                    is ResponseResourceCallback.Exception<*> -> {
                        _uiState.update { currentState ->
                            currentState.copy(
                                isToShowLoading = false,
                                generalMatchList = "failuere"
                            )
                        }
                    }
                }
            }
        }
    }
}
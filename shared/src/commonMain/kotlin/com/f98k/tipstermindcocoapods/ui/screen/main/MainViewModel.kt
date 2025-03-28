package com.f98k.tipstermindcocoapods.ui.screen.main

import androidx.lifecycle.ViewModel
import com.f98k.tipstermindcocoapods.domain.usecase.MainUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class MainViewModel(private val mainUseCase: MainUseCase) : ViewModel() {

    private val _state = MutableStateFlow(MainUiState())
    val uiState: StateFlow<MainUiState> = _state.asStateFlow()

    val uiActions : MainUiStateAction
        get() = MainUiStateAction()
}
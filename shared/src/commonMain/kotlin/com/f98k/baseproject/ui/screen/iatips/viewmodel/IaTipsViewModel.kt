package com.f98k.baseproject.ui.screen.iatips.viewmodel

import androidx.lifecycle.ViewModel
import com.f98k.baseproject.domain.usecase.iatips.IaTipsUseCase
import com.f98k.baseproject.ui.screen.iatips.state.IaTipsUiActions
import com.f98k.baseproject.ui.screen.iatips.state.IaTipsUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class IaTipsViewModel(private val useCase: IaTipsUseCase) : ViewModel() {
    private val _state = MutableStateFlow(IaTipsUiState())
    val uiState: StateFlow<IaTipsUiState> = _state.asStateFlow()

    val uiStateActions: IaTipsUiActions
        get() = IaTipsUiActions()

}
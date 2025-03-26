package com.f98k.tipstermindcocoapods.ui.screen.iatips

import androidx.lifecycle.ViewModel
import com.f98k.tipstermindcocoapods.domain.usecase.iatips.IaTipsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class IaTipsViewModel(private val useCase: IaTipsUseCase) : ViewModel() {
    private val _state = MutableStateFlow(IaTipsUiState())
    val state: StateFlow<IaTipsUiState> = _state.asStateFlow()
}
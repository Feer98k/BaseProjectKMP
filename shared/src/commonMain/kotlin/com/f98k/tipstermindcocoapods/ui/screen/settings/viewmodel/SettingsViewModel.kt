package com.f98k.tipstermindcocoapods.ui.screen.settings.viewmodel

import androidx.lifecycle.ViewModel
import com.f98k.tipstermindcocoapods.domain.usecase.settings.SettingsUseCase
import com.f98k.tipstermindcocoapods.ui.screen.settings.state.SettingsUiActions
import com.f98k.tipstermindcocoapods.ui.screen.settings.state.SettingsUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class SettingsViewModel(private val settingsUseCase: SettingsUseCase) : ViewModel() {
    private val _state = MutableStateFlow(SettingsUiState())
    val state: StateFlow<SettingsUiState> = _state.asStateFlow()

    val uiActions : SettingsUiActions
        get() = SettingsUiActions()
}
package com.f98k.tipstermindcocoapods.ui.screen.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.f98k.tipstermindcocoapods.commons.AppLanguageController
import com.f98k.tipstermindcocoapods.commons.SupportedLanguage
import com.f98k.tipstermindcocoapods.domain.usecase.MainUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MainViewModel(private val useCase: MainUseCase) : ViewModel() {

    private val _uiState = MutableStateFlow(MainUiState())
    val uiState: StateFlow<MainUiState> = _uiState.asStateFlow()

    init {
        getSettingsList()
    }
    val uiActions: MainUiStateAction
        get() = MainUiStateAction(
            getBottomBarList = {
                getBottomBarList()
            },
            setDrawerVisibility = {
                setDrawerVisibility(it)
            },
            setShowManageComponentActions = { booleanValue, actionSelected ->
                setManageComponentActions(booleanValue,actionSelected)
            },
            onChangeLanguage = {
                onChangeLanguage(it)
            }
        )

    private fun onChangeLanguage(language: SupportedLanguage) {
        AppLanguageController.setLanguage(language)
    }

    private fun setManageComponentActions(value: Boolean,actionSelected : String) {
        _uiState.update { it.copy(
            isToShowSettingsActionComponent = value,
            lastActionClicked = actionSelected
        ) }
    }

    private fun setDrawerVisibility(value: Boolean) {
        _uiState.update { it.copy(
            isToShowSettingsDrawer = value
        ) }
    }

    private fun getSettingsList() {
        launchWithLoading(
            onSuccess = { settingsList ->
                _uiState.update { it.copy(
                    settingsList = settingsList
                ) }
            },
            block = { useCase.fetchSettingsList() }
        )
    }

    private fun getBottomBarList() {
        launchWithLoading(
            onSuccess = { bottomBar ->
                _uiState.update { it.copy(bottomBarList = bottomBar) }
            },
            block = { useCase.fetchBottomBarList() }
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
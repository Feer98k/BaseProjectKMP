package com.f98k.baseproject.ui.screen.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.f98k.baseproject.commons.AppLanguageController
import com.f98k.baseproject.commons.AppThemeController
import com.f98k.baseproject.commons.AppThemeType
import com.f98k.baseproject.commons.SupportedLanguage
import com.f98k.baseproject.data.model.bottomsheet.ModalBottomSheetType
import com.f98k.baseproject.domain.bridge.FontSizePreferenceBridge
import com.f98k.baseproject.domain.bridge.LanguageStorageBridge
import com.f98k.baseproject.domain.bridge.ThemeStorageBridge
import com.f98k.baseproject.domain.helper.FontSizeController
import com.f98k.baseproject.domain.helper.FontSizeController.initializeFontSize
import com.f98k.baseproject.domain.helper.initializeTheme
import com.f98k.baseproject.domain.usecase.MainUseCase
import com.f98k.baseproject.ui.theme.FontSizeLevel
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
        viewModelScope.launch {
            AppLanguageController.initialize(LanguageStorageBridge)
            initializeTheme(ThemeStorageBridge)
            initializeFontSize(FontSizePreferenceBridge)
        }
    }
    val uiActions: MainUiStateAction
        get() = MainUiStateAction(
            getBottomBarList = {
                getBottomBarList()
            },
            setDrawerVisibility = {
                setDrawerVisibility(it)
            },
            showBottomSheet = { type ->
                _uiState.update { it.copy(currentBottomSheet = type, isBottomSheetVisible = true) }
            },
            hideBottomSheet = {
                _uiState.update { it.copy(currentBottomSheet = ModalBottomSheetType.NONE_TYPE, isBottomSheetVisible = false) }
            },
            setLanguage = {
                changeLanguage(it)
            },
            setTheme = {
                changeTheme(it)
            },
            setFontSize = {
                changeFontSize(it)
            }
        )

    private fun changeFontSize(fontSizeLevel: FontSizeLevel) {
        viewModelScope.launch {
            FontSizeController.setFontSize(fontSizeLevel)
            FontSizePreferenceBridge.saveFontSize(fontSizeLevel)
        }
    }

    private fun changeTheme(themeType: AppThemeType) {
        viewModelScope.launch {
            ThemeStorageBridge.saveTheme(themeType)
            AppThemeController.setTheme(themeType)
        }
    }

    private fun changeLanguage(it: SupportedLanguage) {
        viewModelScope.launch {
            LanguageStorageBridge.saveLanguage(it)
            AppLanguageController.setLanguage(it)
            getSettingsList()
            getBottomBarList()
        }
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
    fun showBottomSheet(type: ModalBottomSheetType) {
        _uiState.update { it.copy(currentBottomSheet = type, isBottomSheetVisible = true) }
    }

    fun hideBottomSheet() {
        _uiState.update { it.copy(currentBottomSheet = ModalBottomSheetType.NONE_TYPE, isBottomSheetVisible = false) }
    }
}
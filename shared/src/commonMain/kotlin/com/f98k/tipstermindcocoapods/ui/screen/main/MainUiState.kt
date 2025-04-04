package com.f98k.tipstermindcocoapods.ui.screen.main

import com.f98k.tipstermindcocoapods.commons.AppThemeType
import com.f98k.tipstermindcocoapods.commons.StringConstants.EMPTY_STRING
import com.f98k.tipstermindcocoapods.commons.SupportedLanguage
import com.f98k.tipstermindcocoapods.data.model.bottombar.BottomBarList
import com.f98k.tipstermindcocoapods.data.model.settings.SettingsItem
import com.f98k.tipstermindcocoapods.data.model.bottomsheet.ModalBottomSheetType
import com.f98k.tipstermindcocoapods.ui.theme.FontSizeLevel

data class MainUiState(
    val isToShowLoading: Boolean = false,
    val isToShowSettingsDrawer: Boolean = false,
    val isToShowSettingsActionComponent: Boolean = false,
    val lastActionClicked: String = EMPTY_STRING,
    val bottomBarList: BottomBarList = BottomBarList(),
    val settingsList: List<SettingsItem> = emptyList(),
    val currentBottomSheet: ModalBottomSheetType = ModalBottomSheetType.NONE_TYPE,
    val isBottomSheetVisible: Boolean = false
)

data class MainUiStateAction(
    val getBottomBarList: () -> Unit = {},
    val getSettingsList: () -> Unit = {},
    val onSettingsItemClick: (SettingsItem) -> Unit = {},
    val setDrawerVisibility: (Boolean) -> Unit = {},
    val showBottomSheet: (ModalBottomSheetType) -> Unit,
    val hideBottomSheet: () -> Unit,
    val setLanguage:(SupportedLanguage) -> Unit,
    val setTheme:(AppThemeType) -> Unit,
    val setFontSize:(FontSizeLevel) -> Unit
)
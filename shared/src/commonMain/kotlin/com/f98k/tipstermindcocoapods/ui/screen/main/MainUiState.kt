package com.f98k.tipstermindcocoapods.ui.screen.main

import com.f98k.tipstermindcocoapods.commons.SupportedLanguage
import com.f98k.tipstermindcocoapods.data.model.bottombar.BottomBarList
import com.f98k.tipstermindcocoapods.data.model.settings.SettingsItem
import com.f98k.tipstermindcocoapods.commons.StringConstants.EMPTY_STRING

data class MainUiState(
    val isToShowLoading: Boolean = false,
    val isToShowSettingsDrawer: Boolean = false,
    val isToShowSettingsActionComponent: Boolean = false,
    val lastActionClicked: String = EMPTY_STRING,
    val bottomBarList: BottomBarList = BottomBarList(),
    val settingsList: List<SettingsItem> = emptyList()
)

data class MainUiStateAction(
    val getBottomBarList: () -> Unit = {},
    val getSettingsList: () -> Unit = {},
    val onChangeThemeClick: () -> Unit = {},
    val onSettingsItemClick: (SettingsItem) -> Unit = {},
    val setDrawerVisibility: (Boolean) -> Unit = {},
    val setShowManageComponentActions: (Boolean,String) -> Unit,
    val onChangeLanguage: (SupportedLanguage) -> Unit = {}
)


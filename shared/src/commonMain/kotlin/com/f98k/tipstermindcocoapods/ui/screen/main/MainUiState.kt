package com.f98k.tipstermindcocoapods.ui.screen.main

import com.f98k.tipstermindcocoapods.data.model.bottombar.BottomBarList
import com.f98k.tipstermindcocoapods.data.model.settings.SettingsItem

data class MainUiState(
    val isToShowLoading: Boolean = false,
    val isToShowSettingsDrawer: Boolean = false,
    val bottomBarList: BottomBarList = BottomBarList(),
    val settingsList: List<SettingsItem> = emptyList()
)

data class MainUiStateAction(
    val getBottomBarList: () -> Unit = {},
    val getSettingsList: () -> Unit = {},
    val onSettingsItemClick: (SettingsItem) -> Unit = {},
    val setDrawerVisibility: (Boolean) -> Unit = {},
)

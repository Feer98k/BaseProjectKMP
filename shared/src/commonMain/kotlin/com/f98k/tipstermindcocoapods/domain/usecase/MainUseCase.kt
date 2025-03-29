package com.f98k.tipstermindcocoapods.domain.usecase

import com.f98k.tipstermindcocoapods.data.model.bottombar.BottomBarList
import com.f98k.tipstermindcocoapods.data.model.settings.SettingsItem

interface MainUseCase {
    suspend fun fetchBottomBarList(): BottomBarList
    suspend fun fetchSettingsList(): List<SettingsItem>
    suspend fun changeTheme()
}
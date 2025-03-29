package com.f98k.tipstermindcocoapods.data.repository.main

import com.f98k.tipstermindcocoapods.data.model.bottombar.BottomBarList
import com.f98k.tipstermindcocoapods.data.model.settings.SettingsItem

interface MainRepository {
    suspend fun getDefaultBottomBar(): BottomBarList
    suspend fun fetchSettingsList(): List<SettingsItem>
    suspend fun changeAppTheme()
}
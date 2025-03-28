package com.f98k.tipstermindcocoapods.data.repository.main

import com.f98k.tipstermindcocoapods.data.model.bottombar.BottomBarList
import com.f98k.tipstermindcocoapods.data.model.settings.SettingsItem

interface MainRepository {
    fun getDefaultBottomBar(): BottomBarList
    fun fetchSettingsList(): List<SettingsItem>
}
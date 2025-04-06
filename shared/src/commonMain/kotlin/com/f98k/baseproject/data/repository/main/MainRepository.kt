package com.f98k.baseproject.data.repository.main

import com.f98k.baseproject.data.model.bottombar.BottomBarList
import com.f98k.baseproject.data.model.settings.SettingsItem

interface MainRepository {
    fun getDefaultBottomBar(): BottomBarList
    suspend fun fetchSettingsList(): List<SettingsItem>
}
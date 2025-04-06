package com.f98k.baseproject.domain.usecase

import com.f98k.baseproject.data.model.bottombar.BottomBarList
import com.f98k.baseproject.data.model.settings.SettingsItem

interface MainUseCase {
    suspend fun fetchBottomBarList(): BottomBarList
    suspend fun fetchSettingsList(): List<SettingsItem>
}
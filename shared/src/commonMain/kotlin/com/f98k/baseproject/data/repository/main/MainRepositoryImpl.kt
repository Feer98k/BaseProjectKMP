package com.f98k.baseproject.data.repository.main

import com.f98k.baseproject.data.model.bottombar.BottomBarList
import com.f98k.baseproject.data.model.settings.SettingsItem
import com.f98k.baseproject.domain.bridge.readJsonFileFromAssets
import com.f98k.baseproject.domain.extensions.fromJsonOrNull

class MainRepositoryImpl() : MainRepository {

    override fun getDefaultBottomBar(): BottomBarList {
        return readJsonFileFromAssets("bottom_bar_items.json").fromJsonOrNull() ?: BottomBarList()
    }

    override suspend fun fetchSettingsList(): List<SettingsItem> {
        return readJsonFileFromAssets("settings_item.json").fromJsonOrNull() ?: listOf(SettingsItem())
    }
}
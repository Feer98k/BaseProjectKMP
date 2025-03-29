package com.f98k.tipstermindcocoapods.data.repository.main

import com.f98k.tipstermindcocoapods.data.model.bottombar.BottomBarList
import com.f98k.tipstermindcocoapods.data.model.settings.SettingsItem
import com.f98k.tipstermindcocoapods.domain.bridge.readJsonFileFromAssets
import com.f98k.tipstermindcocoapods.domain.extensions.fromJsonOrNull

class MainRepositoryImpl() : MainRepository {

    override suspend fun getDefaultBottomBar(): BottomBarList {
        return readJsonFileFromAssets("bottom_bar_items.json").fromJsonOrNull() ?: BottomBarList()
    }

    override suspend fun fetchSettingsList(): List<SettingsItem> {
        return readJsonFileFromAssets("settings_item.json").fromJsonOrNull() ?: listOf(SettingsItem())
    }

    override suspend fun changeAppTheme() {
        TODO("Not yet implemented")
    }
}
package com.f98k.tipstermindcocoapods.domain.helper

import com.f98k.tipstermindcocoapods.commons.AppThemeController
import com.f98k.tipstermindcocoapods.domain.bridge.ThemeStorageBridge

suspend fun initializeTheme(storage: ThemeStorageBridge) {
    val saved = storage.getSavedTheme()
    saved?.let { AppThemeController.setTheme(it) }
}
package com.f98k.baseproject.domain.helper

import com.f98k.baseproject.commons.AppThemeController
import com.f98k.baseproject.domain.bridge.ThemeStorageBridge

suspend fun initializeTheme(storage: ThemeStorageBridge) {
    val saved = storage.getSavedTheme()
    saved?.let { AppThemeController.setTheme(it) }
}
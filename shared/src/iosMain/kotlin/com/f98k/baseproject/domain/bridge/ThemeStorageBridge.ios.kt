package com.f98k.baseproject.domain.bridge

import com.f98k.baseproject.commons.AppThemeType
import platform.Foundation.NSUserDefaults

actual object ThemeStorageBridge {
    actual suspend fun saveTheme(theme: AppThemeType) {
        NSUserDefaults.standardUserDefaults.setObject(theme.theme, forKey = "selected_theme")
    }

    actual suspend fun getSavedTheme(): AppThemeType? {
        val saved = NSUserDefaults.standardUserDefaults.stringForKey("selected_theme")
        return AppThemeType.entries.find { it.theme == saved }
    }
}
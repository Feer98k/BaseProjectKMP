package com.f98k.tipstermindcocoapods.domain.bridge

import com.f98k.tipstermindcocoapods.commons.AppThemeType

expect object ThemeStorageBridge {
    suspend fun saveTheme(theme: AppThemeType)
    suspend fun getSavedTheme(): AppThemeType?
}
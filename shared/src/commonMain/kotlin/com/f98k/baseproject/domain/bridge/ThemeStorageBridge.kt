package com.f98k.baseproject.domain.bridge

import com.f98k.baseproject.commons.AppThemeType

expect object ThemeStorageBridge {
    suspend fun saveTheme(theme: AppThemeType)
    suspend fun getSavedTheme(): AppThemeType?
}
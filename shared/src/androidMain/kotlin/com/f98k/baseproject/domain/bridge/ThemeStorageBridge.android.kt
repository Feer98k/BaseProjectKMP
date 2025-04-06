package com.f98k.baseproject.domain.bridge

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.f98k.baseproject.commons.AppThemeType
import kotlinx.coroutines.flow.first

actual object ThemeStorageBridge {
    private val Context.dataStore by preferencesDataStore(name = "app_settings_theme")

    actual suspend fun saveTheme(theme: AppThemeType) {
        appContext.dataStore.edit { prefs ->
            prefs[stringPreferencesKey("selected_theme")] = theme.theme
        }
    }

    actual suspend fun getSavedTheme(): AppThemeType? {
        val prefs = appContext.dataStore.data.first()
        return prefs[stringPreferencesKey("selected_theme")]?.let {
            AppThemeType.entries.find { theme -> theme.theme == it }
        }
    }
}
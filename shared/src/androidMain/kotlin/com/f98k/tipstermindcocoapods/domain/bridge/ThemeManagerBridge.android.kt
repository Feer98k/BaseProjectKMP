package com.f98k.tipstermindcocoapods.domain.bridge

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.dataStore by preferencesDataStore("settings")

actual class ThemeManagerBridge(private val context: Context) {
    private val themeKey = booleanPreferencesKey("is_dark_mode")

    actual val isDarkTheme: Flow<Boolean> = context.dataStore.data.map { preferences ->
        preferences[themeKey] ?: false
    }

    actual suspend fun toggleTheme() {
        context.dataStore.edit { settings ->
            val currentTheme = settings[themeKey] ?: false
            settings[themeKey] = !currentTheme
        }
    }
}
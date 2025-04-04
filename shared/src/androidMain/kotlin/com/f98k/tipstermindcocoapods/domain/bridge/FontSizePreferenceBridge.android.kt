package com.f98k.tipstermindcocoapods.domain.bridge

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.f98k.tipstermindcocoapods.ui.theme.FontSizeLevel
import kotlinx.coroutines.flow.first

private const val dataStoredName = "app_settings_font_size"

actual object FontSizePreferenceBridge {
    private val Context.dataStore by preferencesDataStore(name = dataStoredName)

    actual suspend fun saveFontSize(fontSize: FontSizeLevel) {
        appContext.dataStore.edit { prefs ->
            prefs[stringPreferencesKey(dataStoredName)] = fontSize.scale.toString()
        }
    }

    actual suspend fun getFontSize(): FontSizeLevel? {
        val prefs = appContext.dataStore.data.first()
        return prefs[stringPreferencesKey(dataStoredName)]?.let {
            FontSizeLevel.entries.find { theme -> theme.scale.toString() == it }
        }
    }
}
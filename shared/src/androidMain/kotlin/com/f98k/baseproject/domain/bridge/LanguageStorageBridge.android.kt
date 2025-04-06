package com.f98k.baseproject.domain.bridge

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.f98k.baseproject.commons.SupportedLanguage
import kotlinx.coroutines.flow.first

actual object LanguageStorageBridge {
    private val Context.dataStore by preferencesDataStore(name = "app_settings_language")

    actual suspend fun saveLanguage(lang: SupportedLanguage) {
        appContext.dataStore.edit { prefs ->
            prefs[stringPreferencesKey("selected_language")] = lang.lang
        }
    }

    actual suspend fun getSavedLanguage(): SupportedLanguage? {
        val prefs = appContext.dataStore.data.first()
        return prefs[stringPreferencesKey("selected_language")]?.let {
            SupportedLanguage.entries.find { lang -> lang.lang == it }
        }
    }
}
package com.f98k.tipstermindcocoapods.domain.bridge

import com.f98k.tipstermindcocoapods.commons.SupportedLanguage

expect object LanguageStorageBridge {
    suspend fun saveLanguage(lang: SupportedLanguage)
    suspend fun getSavedLanguage(): SupportedLanguage?
}
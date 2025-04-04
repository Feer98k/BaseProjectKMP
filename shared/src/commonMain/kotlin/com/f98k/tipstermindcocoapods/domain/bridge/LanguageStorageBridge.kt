package com.f98k.tipstermindcocoapods.domain.bridge

import com.f98k.tipstermindcocoapods.commons.SupportedLanguage

interface LanguageStorageBridge {
    suspend fun saveLanguage(lang: SupportedLanguage)
    suspend fun getSavedLanguage(): SupportedLanguage?
}
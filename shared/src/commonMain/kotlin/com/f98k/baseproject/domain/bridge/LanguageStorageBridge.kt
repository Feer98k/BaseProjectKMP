package com.f98k.baseproject.domain.bridge

import com.f98k.baseproject.commons.SupportedLanguage

expect object LanguageStorageBridge {
    suspend fun saveLanguage(lang: SupportedLanguage)
    suspend fun getSavedLanguage(): SupportedLanguage?
}
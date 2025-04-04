package com.f98k.tipstermindcocoapods.domain.bridge

import com.f98k.tipstermindcocoapods.commons.SupportedLanguage

import platform.Foundation.NSUserDefaults

actual object LanguageStorageBridge {
    actual suspend fun saveLanguage(lang: SupportedLanguage) {
        NSUserDefaults.standardUserDefaults.setObject(lang.lang, forKey = "selected_language")
    }

    actual suspend fun getSavedLanguage(): SupportedLanguage? {
        val saved = NSUserDefaults.standardUserDefaults.stringForKey("selected_language")
        return SupportedLanguage.entries.find { it.lang == saved }
    }
}
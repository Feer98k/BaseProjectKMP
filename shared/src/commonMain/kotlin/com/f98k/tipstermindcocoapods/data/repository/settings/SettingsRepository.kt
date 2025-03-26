package com.f98k.tipstermindcocoapods.data.repository.settings

interface SettingsRepository {
    suspend fun getLanguageCode(): String

    suspend fun setLanguageCode(languageCode: String)

    suspend fun getCountryCode(): String

    suspend fun setCountryCode(countryCode: String)

    suspend fun getIsDarkModeEnabled(): Boolean

    suspend fun setIsDarkModeEnabled(isDarkModeEnabled: Boolean)
}
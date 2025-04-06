package com.f98k.baseproject.domain.usecase.settings

import com.f98k.baseproject.data.repository.settings.SettingsRepository
import com.f98k.baseproject.domain.usecase.home.HomeUseCase

class SettingsUseCaseImpl(
    private val homeUseCase: HomeUseCase,
    private val repository: SettingsRepository
) : SettingsUseCase {

    override suspend fun getLanguageCode(): String {
        TODO("Not yet implemented")
    }

    override suspend fun setLanguageCode(languageCode: String) {
        TODO("Not yet implemented")
    }

    override suspend fun getCountryCode(): String {
        TODO("Not yet implemented")
    }

    override suspend fun setCountryCode(countryCode: String) {
        TODO("Not yet implemented")
    }

    override suspend fun getIsDarkModeEnabled(): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun setIsDarkModeEnabled(isDarkModeEnabled: Boolean) {
        TODO("Not yet implemented")
    }
}
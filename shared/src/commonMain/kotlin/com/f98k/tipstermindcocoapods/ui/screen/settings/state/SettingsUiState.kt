package com.f98k.tipstermindcocoapods.ui.screen.settings.state

data class SettingsUiState(
    val languageCode: String = "",
    val countryCode: String = "",
    val isDarkModeEnabled: Boolean = false,
    val isLoading: Boolean = false,
    val errorMessage: String? = null
)

data class SettingsUiActions(
    val onLanguageCodeChanged: (String) -> Unit = {},
    val onCountryCodeChanged: (String) -> Unit = {},
    val onDarkModeToggleChanged: (Boolean) -> Unit = {},
    val onSaveButtonClicked: () -> Unit = {},
    val onErrorDismissed: () -> Unit = {}
)

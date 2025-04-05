package com.f98k.tipstermindcocoapods.commons

import com.f98k.tipstermindcocoapods.commons.StringConstants.APP_NAME
import com.f98k.tipstermindcocoapods.domain.bridge.LanguageStorageBridge
import com.f98k.tipstermindcocoapods.domain.bridge.getCurrentLanguageCode
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

enum class SupportedLanguage(val lang : String) {
    EN("en"), PT("pt"), ES("es")
}

fun getSupportedLanguage(): SupportedLanguage {
    return when (getCurrentLanguageCode()) {
        "pt" -> SupportedLanguage.PT
        "es" -> SupportedLanguage.ES
        else -> SupportedLanguage.EN
    }
}

object AppLanguageController {
    private val _currentLanguage = MutableStateFlow(getSupportedLanguage())
    val currentLanguage: StateFlow<SupportedLanguage> get() = _currentLanguage

    suspend fun initialize(languageStorageBridge: LanguageStorageBridge) {
        val stored = languageStorageBridge.getSavedLanguage()
        stored?.let { _currentLanguage.value = it }
    }

    fun setLanguage(lang: SupportedLanguage) {
        _currentLanguage.value = lang
    }
}

object LocalizedStrings {
    private var currentLang = AppLanguageController.currentLanguage.value

    init {
        CoroutineScope(Dispatchers.Default).launch {
            AppLanguageController.currentLanguage.collect {
                currentLang = it
            }
        }
    }

    fun backPressedAccessibility(): String = when (currentLang) {
        SupportedLanguage.EN -> "Back button"
        SupportedLanguage.PT -> "Botão voltar"
        SupportedLanguage.ES -> "Botón de regreso"
    }

    fun topBarFavoriteScreen(): String = when (currentLang) {
        SupportedLanguage.EN -> "My Favorites"
        SupportedLanguage.PT -> "Favoritos"
        SupportedLanguage.ES -> "Favoritos"
    }

    fun topIaTipsScreen(): String = when (currentLang) {
        SupportedLanguage.EN -> "$APP_NAME AI"
        SupportedLanguage.PT -> "$APP_NAME IA"
        SupportedLanguage.ES -> "$APP_NAME IA"
    }

    fun topSearchScreen(): String = when (currentLang) {
        SupportedLanguage.EN -> "Search Matches"
        SupportedLanguage.PT -> "Buscar Partidas"
        SupportedLanguage.ES -> "Buscar Partidos"
    }

    fun topSettingsScreen(): String = when (currentLang) {
        SupportedLanguage.EN -> "Settings"
        SupportedLanguage.PT -> "Configurações"
        SupportedLanguage.ES -> "Configurações"
    }

    fun close(): String = when (currentLang) {
        SupportedLanguage.EN -> "Close"
        SupportedLanguage.PT -> "Fechar"
        SupportedLanguage.ES -> "Fechar"
    }

    fun selectLanguageString(): String = when (currentLang) {
        SupportedLanguage.EN -> "Select Language"
        SupportedLanguage.PT -> "Escolher idioma"
        SupportedLanguage.ES -> "Seleccionar idioma"
    }

    fun selectThemeTitle(): String = when (currentLang) {
        SupportedLanguage.EN -> "Select Theme"
        SupportedLanguage.PT -> "Escolher tema"
        SupportedLanguage.ES -> "Seleccionar tema"
    }

    fun themeSystem(): String = when (currentLang) {
        SupportedLanguage.EN -> "System preference"
        SupportedLanguage.PT -> "Preferência do sistema"
        SupportedLanguage.ES -> "Preferencia del sistema"
    }

    fun themeLight(): String = when (currentLang) {
        SupportedLanguage.EN -> "Light mode"
        SupportedLanguage.PT -> "Modo claro"
        SupportedLanguage.ES -> "Modo claro"
    }

    fun themeDark(): String = when (currentLang) {
        SupportedLanguage.EN -> "Dark mode"
        SupportedLanguage.PT -> "Modo escuro"
        SupportedLanguage.ES -> "Modo escuro"
    }

    fun selectFontSizeTitle(): String= when (currentLang) {
        SupportedLanguage.EN -> "Select Font Size"
        SupportedLanguage.PT -> "Escolher tamanho da fonte"
        SupportedLanguage.ES -> "Seleccionar tamaño de fuente"
    }

    fun confirm(): String = when (currentLang) {
        SupportedLanguage.EN -> "Confirm"
        SupportedLanguage.PT -> "Confirmar"
        SupportedLanguage.ES -> "Confirmar"
    }

    fun previewTextSample(): String = when (currentLang) {
        SupportedLanguage.EN -> "Sample text"
        SupportedLanguage.PT -> "Texto de exemplo"
        SupportedLanguage.ES -> "Texto de ejemplo"
    }

    fun dailyPrayer(): String = when (currentLang) {
        SupportedLanguage.EN -> "Daily Prayer"
        SupportedLanguage.PT -> "Oração diaria"
        SupportedLanguage.ES -> "Oración diaria"
    }

    fun dailyVerse(): String = when(currentLang) {
        SupportedLanguage.EN -> "Daily verse"
        SupportedLanguage.PT -> "Versículo diário"
        SupportedLanguage.ES -> "Verso diário"
    }

    fun dailySermon(): String= when(currentLang) {
        SupportedLanguage.EN -> "Daily sermon"
        SupportedLanguage.PT -> "Sermão diário"
        SupportedLanguage.ES -> "Sermón diario"
    }

}

object StringConstants {
    const val APP_NAME = "Hole Bible daily"
    const val APP_DESCRIPTION = "A simple app to help you remember tips and tricks."
    const val EMPTY_STRING = ""
    const val EMPTY_REMOTE_CONFIG = "{}"
    const val ACTION_CHANGE_LANGUAGE = "action_change_language"
    const val ACTION_CHANGE_THEME = "action_change_theme"
    const val ACTION_NOTIFICATIONS = "action_notifications_center"
    const val ACTION_PRIVACY = "action_privacy_settings"
    const val ACTION_TERMS_CONDITIONS = "action_terms_conditions"
    const val ACTION_RATE_APP = "action_rate_app"
    const val ACTION_CONTACT_US = "action_contact_us"
    const val ACTION_FOLLOW_INSTAGRAM = "action_follow_instagram"
    const val ACTION_BE_PRO = "action_become_tipster_pro"
    const val ACTION_FONT_SIZE= "Alterar tamanho de fonte"
}
package com.f98k.tipstermindcocoapods.commons

import com.f98k.tipstermindcocoapods.commons.StringConstants.APP_NAME
import com.f98k.tipstermindcocoapods.domain.bridge.getCurrentLanguageCode
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

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

    fun setLanguage(lang: SupportedLanguage) {
        _currentLanguage.value = lang
    }
}

object LocalizedStrings {
    private var currentLang = AppLanguageController.currentLanguage.value

    fun backPressedAccessibility(): String = when (currentLang) {
        SupportedLanguage.EN -> "Back button"
        SupportedLanguage.PT -> "Botão de voltar"
        SupportedLanguage.ES -> "Botón Atrás"
    }

    fun topBarFavoriteScreen(): String = when (currentLang) {
        SupportedLanguage.EN -> "My Favorites"
        SupportedLanguage.PT -> "Meus Favoritos"
        SupportedLanguage.ES -> "Mis Favoritos"
    }

    fun topIaTipsScreen(): String = when (currentLang) {
        SupportedLanguage.EN -> "$APP_NAME AI"
        SupportedLanguage.PT -> "$APP_NAME IA"
        SupportedLanguage.ES -> "$APP_NAME IA"
    }

    fun topSearchScreen(): String = when (currentLang) {
        SupportedLanguage.EN -> "Find Matches"
        SupportedLanguage.PT -> "Buscar Jogos"
        SupportedLanguage.ES -> "Buscar Partidos"
    }

    fun topSettingsScreen(): String = when (currentLang) {
        SupportedLanguage.EN -> "Settings"
        SupportedLanguage.PT -> "Configurações"
        SupportedLanguage.ES -> "Ajustes"
    }

    fun close(): String = when (currentLang) {
        SupportedLanguage.EN -> "Close"
        SupportedLanguage.PT -> "Fechar"
        SupportedLanguage.ES -> "cerrar"
    }

    fun selectLanguageString(): String = when (currentLang) {
        SupportedLanguage.EN -> "Select Language"
        SupportedLanguage.PT -> "Selecionar idioma"
        SupportedLanguage.ES -> "cambiar idioma"
    }

}

object StringConstants {
    const val APP_NAME = "TipsterMind"
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
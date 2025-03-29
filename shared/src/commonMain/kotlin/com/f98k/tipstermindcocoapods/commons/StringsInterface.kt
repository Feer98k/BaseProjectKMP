package com.f98k.tipstermindcocoapods.commons

import com.f98k.tipstermindcocoapods.commons.StringConstants.APP_NAME
import com.f98k.tipstermindcocoapods.domain.bridge.getCurrentLanguageCode

enum class SupportedLanguage {
    EN, PT, ES
}

private fun getSupportedLanguage(): SupportedLanguage {
    return when (getCurrentLanguageCode()) {
        "pt" -> SupportedLanguage.PT
        "es" -> SupportedLanguage.ES
        else -> SupportedLanguage.EN
    }
}

object LocalizedStrings {
    private var currentLang = getSupportedLanguage()

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

}

object StringConstants {
    const val APP_NAME = "TipsterMind"
    const val APP_DESCRIPTION = "A simple app to help you remember tips and tricks."
    const val EMPTY_STRING = ""
    const val EMPTY_REMOTE_CONFIG = "{}"
}
package com.f98k.tipstermindcocoapods.commons

enum class SupportedLanguage {
    EN, PT, ES
}

object LocalizedStrings {
    var currentLang: SupportedLanguage = SupportedLanguage.EN

    fun backPressedAccessibility(): String = when (currentLang) {
        SupportedLanguage.EN -> "Back button"
        SupportedLanguage.PT -> "Botão de voltar"
        SupportedLanguage.ES -> "Botón Atrás"
    }

    fun welcome(): String = when (currentLang) {
        SupportedLanguage.EN -> "Welcome!"
        SupportedLanguage.PT -> "Bem-vindo!"
        SupportedLanguage.ES -> "¡Bienvenido!"
    }
}

object StringConstants{
    const val APP_NAME = "TipsterMind"
    const val APP_DESCRIPTION = "A simple app to help you remember tips and tricks."
    const val EMPTY_STRING = ""
}
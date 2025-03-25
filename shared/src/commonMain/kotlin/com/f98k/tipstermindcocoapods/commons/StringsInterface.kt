package com.f98k.tipstermindcocoapods.commons

enum class SupportedLanguage {
    EN, PT, ES
}

object LocalizedStrings {
    var currentLang: SupportedLanguage = SupportedLanguage.EN

    fun hello(): String = when (currentLang) {
        SupportedLanguage.EN -> "Hello"
        SupportedLanguage.PT -> "Olá"
        SupportedLanguage.ES -> "Hola"
    }

    fun welcome(): String = when (currentLang) {
        SupportedLanguage.EN -> "Welcome!"
        SupportedLanguage.PT -> "Bem-vindo!"
        SupportedLanguage.ES -> "¡Bienvenido!"
    }
}

object StringConstants{
    const val APP_NAME = "Tipster Mind"
    const val APP_DESCRIPTION = "A simple app to help you remember tips and tricks."
}
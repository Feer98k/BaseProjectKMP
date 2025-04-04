package com.f98k.tipstermindcocoapods.domain.helper

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.f98k.tipstermindcocoapods.commons.AppLanguageController
import com.f98k.tipstermindcocoapods.commons.SupportedLanguage

@Composable
fun localizedText(
    en: String,
    es: String,
    pt: String
): String {
    val currentLanguage by AppLanguageController.currentLanguage.collectAsState()

    return when (currentLanguage) {
        SupportedLanguage.PT -> pt
        SupportedLanguage.ES -> es
        SupportedLanguage.EN -> en
        else -> {en}
    }
}
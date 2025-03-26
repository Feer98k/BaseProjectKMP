package com.f98k.tipstermindcocoapods.domain.helper

import com.f98k.tipstermindcocoapods.domain.bridge.getCurrentLanguageCode

fun localizedText(
    en: String,
    es: String,
    pt: String
): String {
    return when (getCurrentLanguageCode()) {
        "pt" -> pt
        "es" -> es
        else -> en
    }
}
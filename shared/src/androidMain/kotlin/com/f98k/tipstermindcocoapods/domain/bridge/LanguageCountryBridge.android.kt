package com.f98k.tipstermindcocoapods.domain.bridge

actual fun getCurrentLanguageCode(): String {
    return java.util.Locale.getDefault().language
}
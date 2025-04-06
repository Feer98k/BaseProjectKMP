package com.f98k.baseproject.domain.bridge

actual fun getCurrentLanguageCode(): String {
    return java.util.Locale.getDefault().language
}
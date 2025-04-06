package com.f98k.baseproject.domain.bridge

import platform.Foundation.NSLocaleLanguageCode
import platform.Foundation.componentsFromLocaleIdentifier
import platform.Foundation.preferredLanguages

actual fun getCurrentLanguageCode(): String {
    val preferredLanguages = platform.Foundation.NSLocale.preferredLanguages
    val localeIdentifier = preferredLanguages.firstOrNull() as? String ?: "en"
    val components = platform.Foundation.NSLocale.componentsFromLocaleIdentifier(localeIdentifier)
    val langCode = components[NSLocaleLanguageCode] as? String ?: "en"
    return langCode
}
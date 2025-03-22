package com.f98k.tipstermindcocoapods.domain

actual class TipsterRemoteConfig actual constructor() {
    actual fun getRemoteConfigValue(
        key: String,
        onFetchCompleted: (String?) -> Unit
    ) {
    }
}
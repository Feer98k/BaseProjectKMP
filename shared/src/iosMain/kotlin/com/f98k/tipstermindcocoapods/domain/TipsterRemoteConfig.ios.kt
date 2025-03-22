package com.f98k.tipstermindcocoapods.domain

import kotlinx.cinterop.*
import platform.Foundation.*
import kotlinx.cinterop.ExperimentalForeignApi

//@OptIn(ExperimentalForeignApi::class)
actual class TipsterRemoteConfig actual constructor() {
    actual fun getRemoteConfigValue(
        key: String,
        onFetchCompleted: (String?) -> Unit
    ) {
//        RemoteConfigBridge.shared

    }
}
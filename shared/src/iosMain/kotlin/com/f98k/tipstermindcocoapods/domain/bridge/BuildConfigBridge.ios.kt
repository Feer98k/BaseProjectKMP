package com.f98k.tipstermindcocoapods.domain.bridge

actual object BuildConfigBridge {
    actual val ANALYTICS_ENABLED: Boolean
        get() = true
    actual val IS_LOG_ENABLED: Boolean
        get() = true
}
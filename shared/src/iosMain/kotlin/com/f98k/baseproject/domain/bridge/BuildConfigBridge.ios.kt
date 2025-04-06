package com.f98k.baseproject.domain.bridge

actual object BuildConfigBridge {
    actual val ANALYTICS_ENABLED: Boolean
        get() = true
    actual val IS_LOG_ENABLED: Boolean
        get() = true
}
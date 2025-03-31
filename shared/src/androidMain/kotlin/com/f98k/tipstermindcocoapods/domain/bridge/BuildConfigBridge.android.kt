package com.f98k.tipstermindcocoapods.domain.bridge

import com.f98k.tipstermindcocoapods.BuildConfig

actual object BuildConfigBridge {
    actual val ANALYTICS_ENABLED: Boolean = BuildConfig.ANALYTICS_ENABLED
    actual val IS_LOG_ENABLED: Boolean = BuildConfig.IS_LOG_ENABLED
}
package com.f98k.baseproject.domain.bridge

import android.util.Log
import com.f98k.baseproject.BuildConfig

actual object LoggerBridge {
    private val isLoggerEnabled = BuildConfig.IS_LOG_ENABLED

    actual fun logDebug(message: String) {
        if (isLoggerEnabled) Log.d("TipsterLog", message)
    }

    actual fun logError(message: String) {
        if (isLoggerEnabled)  Log.e("TipsterLog", message)
    }

    actual fun logInfo(message: String) {
        if (isLoggerEnabled) Log.i("TipsterLog", message)
    }
}
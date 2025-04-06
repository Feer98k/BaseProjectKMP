// iosMain/LoggerBridge.kt
package com.f98k.baseproject.domain.bridge

import platform.Foundation.NSLog

actual object LoggerBridge {
    private val isLoggerEnabled = BuildConfigBridge.IS_LOG_ENABLED


    actual fun logDebug(message: String) {
        if (isLoggerEnabled) NSLog("DEBUG: $message")
    }

    actual fun logError(message: String) {
        if (isLoggerEnabled)  NSLog("ERROR: $message")
    }

    actual fun logInfo(message: String) {
        if (isLoggerEnabled)  NSLog("INFO: $message")
    }
}

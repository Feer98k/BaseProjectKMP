package com.f98k.baseproject.domain.bridge

expect object LoggerBridge {
    fun logDebug(message: String)
    fun logError(message: String)
    fun logInfo(message: String)
}
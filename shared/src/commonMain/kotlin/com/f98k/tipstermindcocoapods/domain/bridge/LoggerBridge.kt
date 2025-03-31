package com.f98k.tipstermindcocoapods.domain.bridge

expect class LoggerBridge() {
    fun logDebug(message: String)
    fun logError(message: String)
    fun logInfo(message: String)
}
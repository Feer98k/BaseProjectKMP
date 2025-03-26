package com.f98k.tipstermindcocoapods.domain.extensions

import kotlinx.serialization.json.Json
import kotlinx.serialization.SerializationException

inline fun <reified T> String.fromJsonOrNull(): T? {
    return try {
        Json { ignoreUnknownKeys = true }.decodeFromString<T>(this)
    } catch (e: SerializationException) {
        e.printStackTrace()
        null
    }
}
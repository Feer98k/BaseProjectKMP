package com.f98k.baseproject.domain.extensions

import kotlinx.serialization.SerializationException
import kotlinx.serialization.json.Json

inline fun <reified T> String.fromJsonOrNull(): T? {
    return try {
        Json { ignoreUnknownKeys = true }.decodeFromString<T>(this)
    } catch (e: SerializationException) {
        e.printStackTrace()
        null
    }
}

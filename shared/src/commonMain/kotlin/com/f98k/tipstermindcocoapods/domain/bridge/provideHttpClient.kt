package com.f98k.tipstermindcocoapods.domain.bridge

import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.accept
import io.ktor.client.request.header
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

expect fun getPlatformEngine(): HttpClientEngine

fun provideHttpClient(): HttpClient {
    return HttpClient(getPlatformEngine()) {
        // JSON serialization
        install(ContentNegotiation) {
            json(Json {
                prettyPrint = true
                isLenient = true
                ignoreUnknownKeys = true
            })
        }

        install(HttpTimeout) {
            requestTimeoutMillis = 15_000
            connectTimeoutMillis = 15_000
            socketTimeoutMillis = 15_000
        }


        if (BuildConfigBridge.IS_LOG_ENABLED) {
            install(Logging) {
                logger = object : Logger {
                    override fun log(message: String) {
                        LoggerBridge.logInfo("Ktor → $message")
                    }
                }
                level = LogLevel.ALL
            }
        }

        defaultRequest {
            header(HttpHeaders.ContentType, ContentType.Application.Json)
            accept(ContentType.Application.Json)
        }
    }
}

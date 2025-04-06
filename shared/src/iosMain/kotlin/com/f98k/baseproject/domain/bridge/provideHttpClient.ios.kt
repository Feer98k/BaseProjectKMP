package com.f98k.baseproject.domain.bridge

import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.darwin.*

actual fun getPlatformEngine(): HttpClientEngine {
    return Darwin.create()
}
package com.f98k.tipstermindcocoapods.domain.bridge

import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.okhttp.*

actual fun getPlatformEngine(): HttpClientEngine {
    return OkHttp.create()
}
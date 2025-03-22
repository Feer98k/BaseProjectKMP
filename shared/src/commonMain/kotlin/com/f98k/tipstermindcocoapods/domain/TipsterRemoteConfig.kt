package com.f98k.tipstermindcocoapods.domain

expect class TipsterRemoteConfig() {
    fun getRemoteConfigValue(key: String, onFetchCompleted: (String?) -> Unit)
}
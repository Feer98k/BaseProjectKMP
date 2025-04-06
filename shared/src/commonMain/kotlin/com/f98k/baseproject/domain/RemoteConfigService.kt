package com.f98k.baseproject.domain

interface RemoteConfigService {
    fun getRemoteConfigValue(key: String, onFetchCompleted: (String?) -> Unit)
}

expect object RemoteConfigServiceProvider {
    var remoteConfigService: RemoteConfigService?
}
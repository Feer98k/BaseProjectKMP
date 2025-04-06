package com.f98k.baseproject.domain

actual object RemoteConfigServiceProvider {
    actual var remoteConfigService: RemoteConfigService? = null
}

class IosRemoteConfigService(
    private val fetchRemoteConfigJson: (String, (String?) -> Unit) -> Unit
) : RemoteConfigService {

    override fun getRemoteConfigValue(key: String, onFetchCompleted: (String?) -> Unit) {
        fetchRemoteConfigJson(key, onFetchCompleted)
    }
}
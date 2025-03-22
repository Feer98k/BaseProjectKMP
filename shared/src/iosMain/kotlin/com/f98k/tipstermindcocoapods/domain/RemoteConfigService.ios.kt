package com.f98k.tipstermindcocoapods.domain

actual object RemoteConfigServiceProvider {
    actual var remoteConfigService: RemoteConfigService? = null
}

// Apenas delega chamadas para a instância fornecida pelo Swift
class IosRemoteConfigService(
    private val fetchRemoteConfigJson: (String, (String?) -> Unit) -> Unit
) : RemoteConfigService {

    override fun getRemoteConfigValue(key: String, onFetchCompleted: (String?) -> Unit) {
        fetchRemoteConfigJson(key, onFetchCompleted)
    }
}
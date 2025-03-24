package com.f98k.tipstermindcocoapods.data.repository

import com.f98k.tipstermindcocoapods.data.constants.RemoteConfigEnum
import com.f98k.tipstermindcocoapods.data.model.ResponseResourceCallback
import com.f98k.tipstermindcocoapods.domain.RemoteConfigServiceProvider


class HomeRepository {

    suspend fun getRemoteConfigData(
        remoteConfigEnum: RemoteConfigEnum,
        callback: (ResponseResourceCallback<String>) -> Unit
    ) {
        val remoteConfig = RemoteConfigServiceProvider.remoteConfigService
        remoteConfig?.let {
            it.getRemoteConfigValue(remoteConfigEnum.value) { response ->
                if (!response.isNullOrEmpty()) {
                    callback(
                        ResponseResourceCallback.Success(response)
                    )
                } else {
                    callback(
                        ResponseResourceCallback.Error(
                            message = "Empty response",
                        )
                    )
                }


            }
        } ?: callback(
            ResponseResourceCallback.Exception("RemoteConfigServiceProvider is null")
        )
    }
}
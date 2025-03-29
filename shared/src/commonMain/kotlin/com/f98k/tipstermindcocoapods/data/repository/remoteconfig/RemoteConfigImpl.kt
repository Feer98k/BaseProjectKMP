package com.f98k.tipstermindcocoapods.data.repository.remoteconfig

import com.f98k.tipstermindcocoapods.data.constants.RemoteConfigEnum
import com.f98k.tipstermindcocoapods.data.model.ResponseResource
import com.f98k.tipstermindcocoapods.data.repository.remoteconfig.RemoteConfigImpl.RemoteConfig.REMOTE_CONFIG_NULL
import com.f98k.tipstermindcocoapods.data.repository.remoteconfig.RemoteConfigImpl.RemoteConfig.REMOTE_CONFIG_RESPONSE_IS_NULL_OR_EMPTY
import com.f98k.tipstermindcocoapods.domain.RemoteConfigServiceProvider
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine


class RemoteConfigImpl : RemoteConfig {

    object RemoteConfig {
        const val REMOTE_CONFIG_NULL = "RemoteConfigService is null"
        const val REMOTE_CONFIG_RESPONSE_IS_NULL_OR_EMPTY = "Remote config is empty for key"
    }

    override suspend fun fetchRemoteConfigData(remoteConfigEnum: RemoteConfigEnum): ResponseResource<String> {
        val remoteConfig = RemoteConfigServiceProvider.remoteConfigService
            ?: return ResponseResource.Exception(IllegalStateException(REMOTE_CONFIG_NULL))

        return try {
            suspendCoroutine { continuation ->
                remoteConfig.getRemoteConfigValue(remoteConfigEnum.value) { response ->
                    val result = if (!response.isNullOrEmpty()) {
                        ResponseResource.Success(response)
                    } else {
                        ResponseResource.Error(REMOTE_CONFIG_RESPONSE_IS_NULL_OR_EMPTY)
                    }
                    continuation.resume(result)
                }
            }
        } catch (e: Exception) {
            ResponseResource.Exception(e)
        }
    }
}
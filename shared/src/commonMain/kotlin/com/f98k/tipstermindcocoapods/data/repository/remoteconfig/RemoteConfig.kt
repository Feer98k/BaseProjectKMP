package com.f98k.tipstermindcocoapods.data.repository.remoteconfig

import com.f98k.tipstermindcocoapods.data.constants.RemoteConfigEnum
import com.f98k.tipstermindcocoapods.data.model.ResponseResource


interface RemoteConfig {
    suspend fun fetchRemoteConfigData(remoteConfigEnum: RemoteConfigEnum): ResponseResource<String>
}
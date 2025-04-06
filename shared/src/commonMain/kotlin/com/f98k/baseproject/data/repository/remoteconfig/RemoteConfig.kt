package com.f98k.baseproject.data.repository.remoteconfig

import com.f98k.baseproject.data.constants.RemoteConfigEnum
import com.f98k.baseproject.data.model.ResponseResource


interface RemoteConfig {
    suspend fun fetchRemoteConfigData(remoteConfigEnum: RemoteConfigEnum): ResponseResource<String>
}
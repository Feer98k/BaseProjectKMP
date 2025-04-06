package com.f98k.baseproject.domain.usecase.remoteconfig

import com.f98k.baseproject.data.constants.RemoteConfigEnum
import com.f98k.baseproject.data.model.ResponseResource

interface RemoteConfigUseCase {
    suspend fun fetchRemoteConfigData(remoteConfigEnum: RemoteConfigEnum): ResponseResource<String>
}
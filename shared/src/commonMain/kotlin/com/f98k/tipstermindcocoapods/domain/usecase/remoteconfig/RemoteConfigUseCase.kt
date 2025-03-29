package com.f98k.tipstermindcocoapods.domain.usecase.remoteconfig

import com.f98k.tipstermindcocoapods.data.constants.RemoteConfigEnum
import com.f98k.tipstermindcocoapods.data.model.ResponseResource

interface RemoteConfigUseCase {
    suspend fun fetchRemoteConfigData(remoteConfigEnum: RemoteConfigEnum): ResponseResource<String>
}
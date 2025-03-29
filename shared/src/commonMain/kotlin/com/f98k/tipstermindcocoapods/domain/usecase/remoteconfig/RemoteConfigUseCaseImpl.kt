package com.f98k.tipstermindcocoapods.domain.usecase.remoteconfig

import com.f98k.tipstermindcocoapods.data.constants.RemoteConfigEnum
import com.f98k.tipstermindcocoapods.data.model.ResponseResource
import com.f98k.tipstermindcocoapods.data.repository.remoteconfig.RemoteConfig

class RemoteConfigUseCaseImpl(private val remoteConfigRepository: RemoteConfig) :
    RemoteConfigUseCase {

    override suspend fun fetchRemoteConfigData(remoteConfigEnum: RemoteConfigEnum): ResponseResource<String> {
        return remoteConfigRepository.fetchRemoteConfigData(remoteConfigEnum)
    }
}
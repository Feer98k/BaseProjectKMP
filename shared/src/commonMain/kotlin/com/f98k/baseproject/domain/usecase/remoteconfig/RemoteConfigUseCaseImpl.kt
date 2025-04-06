package com.f98k.baseproject.domain.usecase.remoteconfig

import com.f98k.baseproject.data.constants.RemoteConfigEnum
import com.f98k.baseproject.data.model.ResponseResource
import com.f98k.baseproject.data.repository.remoteconfig.RemoteConfig

class RemoteConfigUseCaseImpl(private val remoteConfigRepository: RemoteConfig) :
    RemoteConfigUseCase {

    override suspend fun fetchRemoteConfigData(remoteConfigEnum: RemoteConfigEnum): ResponseResource<String> {
        return remoteConfigRepository.fetchRemoteConfigData(remoteConfigEnum)
    }
}
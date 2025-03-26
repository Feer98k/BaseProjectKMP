package com.f98k.tipstermindcocoapods.domain.usecase.home

import com.f98k.tipstermindcocoapods.data.constants.RemoteConfigEnum
import com.f98k.tipstermindcocoapods.data.model.BottomBarList
import com.f98k.tipstermindcocoapods.data.model.ResponseResource
import com.f98k.tipstermindcocoapods.data.repository.home.HomeRepository
import com.f98k.tipstermindcocoapods.data.repository.remoteconfig.RemoteConfig
import com.f98k.tipstermindcocoapods.domain.extensions.fromJsonOrNull

class HomeUseCaseImpl(
    private val homeRepository: HomeRepository,
    private val remoteConfigRepository: RemoteConfig
) : HomeUseCase {

    override suspend fun fetchRemoteConfigData(remoteConfigEnum: RemoteConfigEnum): BottomBarList {
        return when (val result = remoteConfigRepository.fetchRemoteConfigData(remoteConfigEnum)) {
            is ResponseResource.Success -> result.data.fromJsonOrNull<BottomBarList>()
                ?: getDefaultBottomBar()

            is ResponseResource.Error -> getDefaultBottomBar()
            is ResponseResource.Exception -> getDefaultBottomBar()
        }
    }

    override suspend fun generalMatches(): String {
        return when (val result =
            remoteConfigRepository.fetchRemoteConfigData(RemoteConfigEnum.GENERAL_MATCHES_HML)) {
            is ResponseResource.Success -> result.data
            is ResponseResource.Error -> result.message
            is ResponseResource.Exception -> result.throwable.message.toString()
        }
    }

    private fun getDefaultBottomBar(): BottomBarList {
        return homeRepository.getDefaultBottomBar()
    }
}
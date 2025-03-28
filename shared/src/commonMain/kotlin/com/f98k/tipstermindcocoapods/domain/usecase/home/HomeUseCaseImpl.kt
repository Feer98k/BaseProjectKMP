package com.f98k.tipstermindcocoapods.domain.usecase.home

import com.f98k.tipstermindcocoapods.data.constants.RemoteConfigEnum
import com.f98k.tipstermindcocoapods.data.model.BottomBarList
import com.f98k.tipstermindcocoapods.data.model.ResponseResource
import com.f98k.tipstermindcocoapods.data.repository.home.HomeRepository
import com.f98k.tipstermindcocoapods.data.repository.remoteconfig.RemoteConfig
import com.f98k.tipstermindcocoapods.domain.extensions.fromJsonOrNull
import com.f98k.tipstermindcocoapods.domain.usecase.remoteconfig.RemoteConfigUseCase

class HomeUseCaseImpl(
    private val homeRepository: HomeRepository,
    private val remoteConfigUseCase: RemoteConfigUseCase
) : HomeUseCase {


    override suspend fun generalMatches(): String {
        return when (val result =
            remoteConfigUseCase.fetchRemoteConfigData(RemoteConfigEnum.GENERAL_MATCHES_HML)) {
            is ResponseResource.Success -> result.data
            is ResponseResource.Error -> result.message
            is ResponseResource.Exception -> result.throwable.message.toString()
        }
    }
}
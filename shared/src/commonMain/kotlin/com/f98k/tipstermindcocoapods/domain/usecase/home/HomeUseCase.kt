package com.f98k.tipstermindcocoapods.domain.usecase.home

import com.f98k.tipstermindcocoapods.data.constants.RemoteConfigEnum
import com.f98k.tipstermindcocoapods.data.model.BottomBarList

interface HomeUseCase {
    suspend fun fetchRemoteConfigData(remoteConfigEnum: RemoteConfigEnum): BottomBarList
    suspend fun generalMatches(): String
}
package com.f98k.baseproject.domain.usecase.home

import MatchesFootballResponseModel
import com.f98k.baseproject.data.constants.RemoteConfigEnum
import com.f98k.baseproject.data.model.ResponseResource
import com.f98k.baseproject.data.repository.home.HomeRepository
import com.f98k.baseproject.domain.extensions.fromJsonOrNull
import com.f98k.baseproject.domain.usecase.remoteconfig.RemoteConfigUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope


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

    override suspend fun allLeaguesMatches(): List<MatchesFootballResponseModel> = coroutineScope {
        val leagues = listOf(
            RemoteConfigEnum.PREMIER_LEAGUE,
            RemoteConfigEnum.LA_LIGA,
            RemoteConfigEnum.SERIE_A,
            RemoteConfigEnum.BRASILEIRAO,

        )

        leagues.map { league ->
            async(Dispatchers.IO) { // Dispara cada fetch numa coroutine independente em IO
                val result = remoteConfigUseCase.fetchRemoteConfigData(league)
                val raw = (result as? ResponseResource.Success)?.data
                raw?.fromJsonOrNull<MatchesFootballResponseModel>()
            }
        }.awaitAll().filterNotNull()
    }

}
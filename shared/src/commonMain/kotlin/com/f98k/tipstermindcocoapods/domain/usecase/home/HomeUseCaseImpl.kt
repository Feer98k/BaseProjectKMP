package com.f98k.tipstermindcocoapods.domain.usecase.home

import MatchesFootballResponseModel
import com.f98k.tipstermindcocoapods.data.constants.RemoteConfigEnum
import com.f98k.tipstermindcocoapods.data.model.ResponseResource
import com.f98k.tipstermindcocoapods.data.repository.home.HomeRepository
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

    override suspend fun allLeaguesMatches(): List<MatchesFootballResponseModel> {
        val leagues = listOf(
            RemoteConfigEnum.PREMIER_LEAGUE,
            RemoteConfigEnum.LA_LIGA,
            RemoteConfigEnum.SERIE_A,
            RemoteConfigEnum.BUNDESLIGA,
            RemoteConfigEnum.LIGUE_1,
            RemoteConfigEnum.BRASILEIRAO,
            RemoteConfigEnum.MLS,
            RemoteConfigEnum.LIGA_PORTUGAL,
            RemoteConfigEnum.EREDIVISIE,
            RemoteConfigEnum.SAUDI_PRO_LEAGUE,
            RemoteConfigEnum.ARGENTINE_PRIMERA,
            RemoteConfigEnum.J1_LEAGUE,
            RemoteConfigEnum.CHINESE_SUPER_LEAGUE,
            RemoteConfigEnum.SCOTTISH_PREMIERSHIP,
            RemoteConfigEnum.BELGIAN_PRO_LEAGUE,
            RemoteConfigEnum.UEFA_CHAMPIONS_LEAGUE,
            RemoteConfigEnum.UEFA_EUROPA_LEAGUE,
            RemoteConfigEnum.COPA_LIBERTADORES,
            RemoteConfigEnum.AFC_CHAMPIONS_LEAGUE,
            RemoteConfigEnum.FIFA_WORLD_CUP,
            RemoteConfigEnum.UEFA_EURO,
            RemoteConfigEnum.COPA_AMERICA,
            RemoteConfigEnum.GOLD_CUP
        )

        return leagues.mapNotNull { league ->
            val result = remoteConfigUseCase.fetchRemoteConfigData(league)
            val raw = (result as? ResponseResource.Success)?.data
            raw?.fromJsonOrNull<MatchesFootballResponseModel>()
        }
    }

}
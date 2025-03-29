package com.f98k.tipstermindcocoapods.domain.usecase.home

import MatchesFootballResponseModel

interface HomeUseCase {
    suspend fun generalMatches(): String

   suspend fun allLeaguesMatches(): List<MatchesFootballResponseModel>
}
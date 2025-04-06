package com.f98k.baseproject.domain.usecase.home

import MatchesFootballResponseModel

interface HomeUseCase {
    suspend fun generalMatches(): String

   suspend fun allLeaguesMatches(): List<MatchesFootballResponseModel>
}
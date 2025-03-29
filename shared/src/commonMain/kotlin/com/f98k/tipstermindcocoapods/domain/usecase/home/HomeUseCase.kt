package com.f98k.tipstermindcocoapods.domain.usecase.home

interface HomeUseCase {
    suspend fun generalMatches(): String
}
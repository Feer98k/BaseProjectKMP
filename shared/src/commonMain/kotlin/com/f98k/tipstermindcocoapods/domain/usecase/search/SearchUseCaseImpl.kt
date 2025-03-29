package com.f98k.tipstermindcocoapods.domain.usecase.search

import com.f98k.tipstermindcocoapods.domain.usecase.home.HomeUseCase

class SearchUseCaseImpl(private val homeUseCase: HomeUseCase) : SearchUseCase {

    override suspend fun search(query: String): List<String> {
        TODO("Not yet implemented")
    }

    override suspend fun getSearchHistory(): List<String> {
        TODO("Not yet implemented")
    }

    override suspend fun saveSearchHistory(query: String) {
        TODO("Not yet implemented")
    }

    override suspend fun clearSearchHistory() {
        TODO("Not yet implemented")
    }
}
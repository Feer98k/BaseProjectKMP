package com.f98k.baseproject.domain.usecase.search

interface SearchUseCase {

    suspend fun search(query: String): List<String>

    suspend fun getSearchHistory(): List<String>

    suspend fun saveSearchHistory(query: String)

    suspend fun clearSearchHistory()
}
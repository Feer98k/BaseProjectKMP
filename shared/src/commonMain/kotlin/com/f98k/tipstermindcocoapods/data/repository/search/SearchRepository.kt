package com.f98k.tipstermindcocoapods.data.repository.search

interface SearchRepository {
    suspend fun search(query: String): List<String>
}
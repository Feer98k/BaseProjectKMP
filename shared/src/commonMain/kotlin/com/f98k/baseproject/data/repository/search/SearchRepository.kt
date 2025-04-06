package com.f98k.baseproject.data.repository.search

interface SearchRepository {
    suspend fun search(query: String): List<String>
}
package com.f98k.tipstermindcocoapods.domain.usecase.iatips

interface IaTipsUseCase {
    suspend fun getTips(
        searchText: String,
        languageCode: String,
        countryCode: String,
        page: Int,
        pageSize: Int
    ): List<String>

    suspend fun getTipDetails(tipId: String): String

    suspend fun saveTip(tipId: String)

    suspend fun deleteTip(tipId: String)

    suspend fun getSavedTips(): List<String>
}
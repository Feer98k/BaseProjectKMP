package com.f98k.tipstermindcocoapods.data.repository.iatips

class IaTipsRepositoryImpl : IaTipsRepository {
    override suspend fun getTips(
        searchText: String,
        languageCode: String,
        countryCode: String,
        page: Int,
        pageSize: Int
    ): List<String> {
        TODO("Not yet implemented")
    }

    override suspend fun getTipDetails(tipId: String): String {
        TODO("Not yet implemented")
    }

    override suspend fun saveTip(tipId: String) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteTip(tipId: String) {
        TODO("Not yet implemented")
    }

    override suspend fun getSavedTips(): List<String> {
        TODO("Not yet implemented")
    }
}
package com.f98k.tipstermindcocoapods.domain.usecase.favorite

import com.f98k.tipstermindcocoapods.data.repository.favorite.FavoriteRepository
import com.f98k.tipstermindcocoapods.domain.usecase.home.HomeUseCase

class FavoriteUseCaseImpl(
    private val homeUseCase: HomeUseCase,
    private val repository: FavoriteRepository) : FavoriteUseCase {

    override suspend fun getAllFavorite(): List<String> {
        TODO("Not yet implemented")
    }

    override suspend fun addToFavorite(favorite: String) {
        TODO("Not yet implemented")
    }

    override suspend fun removeFromFavorite(favorite: String) {
        TODO("Not yet implemented")
    }

    override suspend fun isFavorite(favorite: String): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun getAllFavoriteCount(): Int {
        TODO("Not yet implemented")
    }
}
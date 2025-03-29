package com.f98k.tipstermindcocoapods.domain.usecase.favorite

interface FavoriteUseCase {

    suspend fun getAllFavorite(): List<String>

    suspend fun addToFavorite(favorite: String)

    suspend fun removeFromFavorite(favorite: String)

    suspend fun isFavorite(favorite: String): Boolean

    suspend fun getAllFavoriteCount(): Int
}
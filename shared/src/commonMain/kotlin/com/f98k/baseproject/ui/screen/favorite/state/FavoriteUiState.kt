package com.f98k.baseproject.ui.screen.favorite.state

import com.f98k.baseproject.commons.StringConstants.EMPTY_STRING

data class FavoriteUiState(
    val isToShowLoading: Boolean = false,
    val favoriteMatchList: String = EMPTY_STRING,
)

data class FavoriteUiActions(
    val getFavoriteMatchList: () -> Unit = {},
    val onErrorDismissed: () -> Unit = {}
)
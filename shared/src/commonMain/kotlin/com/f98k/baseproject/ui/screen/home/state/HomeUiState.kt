package com.f98k.baseproject.ui.screen.home.state

import MatchesFootballResponseModel

data class HomeUiState(
    val isToShowLoading: Boolean = false,
    val generalMatchList: List<MatchesFootballResponseModel> = emptyList()
)

data class HomeUiActions(
    val getGeneralMatchList: () -> Unit = {}
)
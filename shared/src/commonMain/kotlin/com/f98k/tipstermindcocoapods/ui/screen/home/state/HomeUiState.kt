package com.f98k.tipstermindcocoapods.ui.screen.home.state

import com.f98k.tipstermindcocoapods.commons.StringConstants.EMPTY_STRING

data class HomeUiState(
    val isToShowLoading: Boolean = false,
    val generalMatchList: String = EMPTY_STRING
)

data class HomeUiActions(
    val getGeneralMatchList: () -> Unit = {}
)
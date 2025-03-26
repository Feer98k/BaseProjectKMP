package com.f98k.tipstermindcocoapods.ui.home.state

import com.f98k.tipstermindcocoapods.commons.StringConstants.EMPTY_STRING
import com.f98k.tipstermindcocoapods.data.model.BottomBarList

data class HomeUiState(
    val isToShowLoading: Boolean = false,
    val generalMatchList: String = EMPTY_STRING,
    val bottomBarList: BottomBarList = BottomBarList()
)

data class HomeUiActions(
    val getRemoteConfigData: () -> Unit = {},
    val getBottomBarList: () -> Unit = {}
)
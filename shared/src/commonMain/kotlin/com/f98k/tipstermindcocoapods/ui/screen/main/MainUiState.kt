package com.f98k.tipstermindcocoapods.ui.screen.main

import com.f98k.tipstermindcocoapods.data.model.BottomBarList

data class MainUiState(
    val isToShowLoading: Boolean = false,
    val bottomBarList: BottomBarList = BottomBarList()
)
data class MainUiStateAction(
    val getBottomBarList: () -> Unit = {}
)

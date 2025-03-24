package com.f98k.tipstermindcocoapods.ui.state

data class HomeUiState(
    val isLoading:Boolean = false,
    val jsonData: String = "",
    val getRemoteConfigData:() -> Unit = {},
)
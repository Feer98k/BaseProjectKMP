package com.f98k.tipstermindcocoapods.android

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.f98k.tipstermindcocoapods.ui.presentation.HomeScreenApp
import com.f98k.tipstermindcocoapods.ui.state.HomeUiState

@Preview
@Composable
private fun PlayGround(){

    val uiState = HomeUiState(
        jsonData = "Loading..."
    )
    HomeScreenApp(uiState)
}
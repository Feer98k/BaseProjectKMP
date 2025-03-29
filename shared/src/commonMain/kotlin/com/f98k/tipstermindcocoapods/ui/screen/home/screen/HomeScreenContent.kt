package com.f98k.tipstermindcocoapods.ui.screen.home.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.f98k.tipstermindcocoapods.ui.components.TipsterText
import com.f98k.tipstermindcocoapods.ui.screen.home.state.HomeUiActions
import com.f98k.tipstermindcocoapods.ui.screen.home.state.HomeUiState
import com.f98k.tipstermindcocoapods.ui.theme.TipsterTextTypeEnum


@Composable
fun HomeScreenContent(
    uiState: HomeUiState,
    uiStateAction: HomeUiActions
) {
    Card(
        modifier = Modifier
            .fillMaxSize()
    ) {
        LazyColumn {
            item {
                TipsterText(
                    text = uiState.generalMatchList,
                    type = TipsterTextTypeEnum.Body
                )
            }

        }
    }
}

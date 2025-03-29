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
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.ui.unit.dp


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
                uiState.generalMatchList.forEach{ match ->
                    TipsterText(
                        text = match.matches[0].homeTeam,
                        type = TipsterTextTypeEnum.Body
                    )
                    Spacer(modifier = Modifier.width(12.dp))
                }
            }
        }
    }
}

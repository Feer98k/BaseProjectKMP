package com.f98k.tipstermindcocoapods.ui.screen.home.screen

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
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
                uiState.generalMatchList.forEach { match ->
                    
                    Spacer(modifier = Modifier.height(14.dp))
                    match.matches.forEach { actualMatch ->
                        Spacer(modifier = Modifier.height(14.dp))
                        TipsterText(
                            text = "${actualMatch.homeTeam} VS ${actualMatch.awayTeam}",
                            type = TipsterTextTypeEnum.Body
                        )
                    }
                }

            kotlin.runCatching {
                uiState.generalMatchList[0].matches.size
            }.onSuccess{
                Spacer(modifier = Modifier.height(14.dp))
                TipsterText(
                    text = "Total Partidas: ${uiState.generalMatchList[0].matches.size?:0}",
                    type = TipsterTextTypeEnum.Body
                )
            }
            }

        }
    }
}

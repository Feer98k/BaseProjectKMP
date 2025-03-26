package com.f98k.tipstermindcocoapods.ui.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.f98k.tipstermindcocoapods.ui.components.TipsterText
import com.f98k.tipstermindcocoapods.ui.state.HomeUiActions
import com.f98k.tipstermindcocoapods.ui.state.HomeUiState


@Composable
fun HomeScreenContent(
    uiState: HomeUiState,
    uiStateAction: HomeUiActions
) {
    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        LazyColumn {
            item {
                Button(
                    onClick = {
                        uiStateAction.getRemoteConfigData()
                    },
                    modifier = Modifier
                        .padding(16.dp)
                        .clickable { }
                ) {
                    TipsterText(
                        text = "Get Data !",
                        color = Color.White
                    )
                }
                Spacer(modifier = Modifier.padding(16.dp))
                TipsterText(
                    text = uiState.generalMatchList,
                    color = Color.White
                )
            }

        }
    }
}

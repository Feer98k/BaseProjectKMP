package com.f98k.tipstermindcocoapods.ui.screen.search.screen

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.f98k.tipstermindcocoapods.ui.components.TipsterText
import com.f98k.tipstermindcocoapods.ui.screen.search.state.SearchUiActions
import com.f98k.tipstermindcocoapods.ui.screen.search.state.SearchUiState
import com.f98k.tipstermindcocoapods.ui.theme.TipsterTextTypeEnum


@Composable
fun SearchScreenContent(
    uiState: SearchUiState,
    uiStateActions: SearchUiActions
) {
    Card(
        modifier = Modifier
            .fillMaxSize()
    ) {
        LazyColumn {
            item {
                Spacer(modifier = Modifier.padding(16.dp))
                TipsterText(
                    modifier = Modifier.fillMaxSize(),
                    text = "Search Section",
                    type = TipsterTextTypeEnum.Body,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}
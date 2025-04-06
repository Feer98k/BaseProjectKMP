package com.f98k.baseproject.ui.screen.favorite.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.f98k.baseproject.ui.components.TipsterText
import com.f98k.baseproject.ui.screen.favorite.state.FavoriteUiActions
import com.f98k.baseproject.ui.screen.favorite.state.FavoriteUiState
import com.f98k.baseproject.ui.theme.TipsterTextTypeEnum


@Composable
fun FavoriteScreenContent(
    uiState: FavoriteUiState,
    uiStateActions: FavoriteUiActions

) {
    Card(
        modifier = Modifier
            .fillMaxSize()
    ) {
        LazyColumn {
            item {
                TipsterText(
                    modifier = Modifier.fillMaxSize(),
                    text = "Favorite Section",
                    type = TipsterTextTypeEnum.Body,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}
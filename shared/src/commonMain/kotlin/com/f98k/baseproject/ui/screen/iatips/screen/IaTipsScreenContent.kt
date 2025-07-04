package com.f98k.baseproject.ui.screen.iatips.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.f98k.baseproject.ui.components.TipsterText
import com.f98k.baseproject.ui.screen.iatips.state.IaTipsUiActions
import com.f98k.baseproject.ui.screen.iatips.state.IaTipsUiState
import com.f98k.baseproject.ui.theme.TipsterTextTypeEnum


@Composable
fun IaTipsScreenContent(
    uiState: IaTipsUiState,
    uiStateActions: IaTipsUiActions
) {
    Card(
        modifier = Modifier
            .fillMaxSize()
    ) {
        LazyColumn {
            item {
                TipsterText(
                    modifier = Modifier.fillMaxSize(),
                    text = "Ia Tips Section",
                    type = TipsterTextTypeEnum.Body,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}
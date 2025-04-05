package com.f98k.tipstermindcocoapods.ui.screen.home.screen

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.f98k.tipstermindcocoapods.ui.components.TipsterText
import com.f98k.tipstermindcocoapods.ui.screen.home.state.HomeUiActions
import com.f98k.tipstermindcocoapods.ui.screen.home.state.HomeUiState
import com.f98k.tipstermindcocoapods.ui.theme.TipsterTextTypeEnum

@Composable
fun DailySermonContent(
    uiState: HomeUiState,
    uiStateAction: HomeUiActions
) {
    TipsterText(
        text = "Reflexão sobre a paciência de Jó.",
        type = TipsterTextTypeEnum.Body,
        modifier = Modifier.padding(16.dp)
    )
}
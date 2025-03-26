package com.f98k.tipstermindcocoapods.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.size
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.f98k.tipstermindcocoapods.ui.screen.HomeScreenApp
import com.f98k.tipstermindcocoapods.ui.state.HomeUiState
import com.f98k.tipstermindcocoapods.ui.theme.TipsterTheme
import com.f98k.tipstermindcocoapods.ui.viewmodel.HomeViewModel
import org.koin.androidx.compose.koinViewModel


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel = koinViewModel<HomeViewModel>()
            TipsterTheme {
                HomeScreenApp(
                    uiState = viewModel.uiState.collectAsState().value,
                    uiStateActions = viewModel.actions
                )
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
private fun HomeAppPreview() {
    val viewModel = koinViewModel<HomeViewModel>()
    TipsterTheme {
        HomeScreenApp(
            uiState = viewModel.uiState.collectAsState().value,
            uiStateActions = viewModel.actions
        )
    }
}
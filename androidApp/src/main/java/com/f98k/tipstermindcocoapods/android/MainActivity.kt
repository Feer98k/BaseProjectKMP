package com.f98k.tipstermindcocoapods.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.tooling.preview.Preview
import com.f98k.tipstermindcocoapods.domain.bridge.initJsonReader
import com.f98k.tipstermindcocoapods.ui.HomeScreenApp
import com.f98k.tipstermindcocoapods.ui.theme.TipsterTheme
import com.f98k.tipstermindcocoapods.ui.screen.home.viewmodel.HomeViewModel
import org.koin.androidx.compose.koinViewModel

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injectLibraries()
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

    private fun injectLibraries(){
        initJsonReader(this@MainActivity)
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
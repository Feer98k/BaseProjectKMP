package com.f98k.tipstermindcocoapods.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.tooling.preview.Preview
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
                HomeScreenApp(viewModel.uiState.collectAsState().value)
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
private fun HomeAppPreview(){
    HomeScreenApp(HomeUiState(jsonData = "testando"))
}
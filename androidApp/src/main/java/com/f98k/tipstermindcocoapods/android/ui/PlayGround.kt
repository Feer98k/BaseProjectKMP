package com.f98k.tipstermindcocoapods.android.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.f98k.tipstermindcocoapods.ui.viewmodel.HomeViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
private fun PlayGround() {
    val viewModel = koinViewModel<HomeViewModel>()
    val uiState = viewModel.uiState.collectAsState().value

    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Button(
                onClick = {
                    uiState.getRemoteConfigData()
                },
                modifier = Modifier
                    .padding(16.dp)
                    .clickable { }
            ) {
                Text("Get Remote Config Data")
            }
            Spacer(modifier = Modifier.padding(16.dp))
            Text(uiState.jsonData)
        }

    }
}

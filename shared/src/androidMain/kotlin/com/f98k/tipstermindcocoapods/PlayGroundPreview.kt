package com.f98k.tipstermindcocoapods

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.f98k.tipstermindcocoapods.ui.viewmodel.HomeViewModel
import org.koin.compose.koinInject

@Preview(showBackground = true)
@Composable
private fun PlayGround(){
    val viewModel = koinInject<HomeViewModel>()
    val uiState = viewModel.uiState.collectAsState().value
    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        LazyColumn(
            modifier = Modifier
        ) {
            item {
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
}
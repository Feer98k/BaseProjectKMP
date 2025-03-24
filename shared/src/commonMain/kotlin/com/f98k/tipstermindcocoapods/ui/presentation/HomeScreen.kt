package com.f98k.tipstermindcocoapods.ui.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.f98k.tipstermindcocoapods.ui.state.HomeUiState

@Composable
fun HomeScreenApp(uiState: HomeUiState) {
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

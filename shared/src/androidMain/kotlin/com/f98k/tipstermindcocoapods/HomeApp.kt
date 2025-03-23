package com.f98k.tipstermindcocoapods

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun TestApp(){
    Card {
        Column {
            Text("Hello")
            Spacer(Modifier.height(30.dp))
        }
    }
}
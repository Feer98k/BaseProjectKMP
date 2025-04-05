package com.f98k.tipstermindcocoapods.data.model.home

import androidx.compose.runtime.Composable

data class TabItem(
    val iconName: String,
    val title: String,
    val content: @Composable () -> Unit
)
package com.f98k.tipstermindcocoapods.domain.bridge


import kotlinx.coroutines.flow.Flow

expect class ThemeManagerBridge {
    val isDarkTheme: Flow<Boolean>
    suspend fun toggleTheme()
}
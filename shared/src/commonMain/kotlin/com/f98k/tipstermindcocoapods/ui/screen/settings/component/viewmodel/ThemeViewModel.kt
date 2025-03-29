package com.f98k.tipstermindcocoapods.ui.screen.settings.component.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class ThemeViewModel : ViewModel() {

    var isDarkTheme by mutableStateOf(false)
        private set

    fun toggleTheme() {
        isDarkTheme = !isDarkTheme
    }
    fun setInitialValue(isDarkThemeValue : Boolean){
        isDarkTheme = isDarkThemeValue
    }
}
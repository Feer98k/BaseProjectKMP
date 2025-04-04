package com.f98k.tipstermindcocoapods.commons

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

enum class AppThemeType(val theme: String) {
    SYSTEM("system"), LIGHT("light"), DARK("dark");
}
object AppThemeController {
    private val _currentTheme = MutableStateFlow(AppThemeType.SYSTEM)
    val currentTheme: StateFlow<AppThemeType> get() = _currentTheme

    fun setTheme(theme: AppThemeType) {
        _currentTheme.value = theme
    }
}
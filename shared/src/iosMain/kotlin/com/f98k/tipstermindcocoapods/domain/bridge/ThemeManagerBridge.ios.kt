package com.f98k.tipstermindcocoapods.domain.bridge

import kotlinx.coroutines.flow.Flow

import kotlinx.coroutines.flow.MutableStateFlow
import platform.Foundation.NSUserDefaults

actual class ThemeManagerBridge {
    private val defaults = NSUserDefaults.standardUserDefaults
    private val themeKey = "is_dark_mode"

    private val _isDarkTheme = MutableStateFlow(defaults.boolForKey(themeKey))
    actual val isDarkTheme: Flow<Boolean> = _isDarkTheme

    actual suspend fun toggleTheme() {
        val newTheme = !_isDarkTheme.value
        defaults.setBool(newTheme, themeKey)
        _isDarkTheme.value = newTheme
    }
}
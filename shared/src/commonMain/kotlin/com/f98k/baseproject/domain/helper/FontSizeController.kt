package com.f98k.baseproject.domain.helper

import com.f98k.baseproject.domain.bridge.FontSizePreferenceBridge
import com.f98k.baseproject.ui.theme.FontSizeLevel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

object FontSizeController {
    private val _currentSize = MutableStateFlow(FontSizeLevel.NORMAL)
    val currentSize: StateFlow<FontSizeLevel> get() = _currentSize

    fun setFontSize(level: FontSizeLevel) {
        _currentSize.value = level
    }

    suspend fun initializeFontSize(storage: FontSizePreferenceBridge) {
        val stored = storage.getFontSize()
        stored?.let { _currentSize.value = it }
    }
}
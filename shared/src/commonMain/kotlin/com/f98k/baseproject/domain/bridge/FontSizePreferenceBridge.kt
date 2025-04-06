package com.f98k.baseproject.domain.bridge

import com.f98k.baseproject.ui.theme.FontSizeLevel

expect object FontSizePreferenceBridge {
    suspend fun saveFontSize(fontSize: FontSizeLevel)
    suspend fun getFontSize(): FontSizeLevel?
}
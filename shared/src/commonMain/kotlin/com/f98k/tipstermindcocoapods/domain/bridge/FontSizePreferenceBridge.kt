package com.f98k.tipstermindcocoapods.domain.bridge

import com.f98k.tipstermindcocoapods.ui.theme.FontSizeLevel

expect object FontSizePreferenceBridge {
    suspend fun saveFontSize(fontSize: FontSizeLevel)
    suspend fun getFontSize(): FontSizeLevel?
}
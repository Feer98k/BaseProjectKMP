package com.f98k.baseproject.domain.bridge

import com.f98k.baseproject.ui.theme.FontSizeLevel
import platform.Foundation.NSUserDefaults

actual object FontSizePreferenceBridge {
    actual suspend fun saveFontSize(fontSize: FontSizeLevel) {
        NSUserDefaults.standardUserDefaults.setObject(fontSize.scale, forKey = "font_size")
    }

    actual suspend fun getFontSize(): FontSizeLevel? {
        val saved = NSUserDefaults.standardUserDefaults.stringForKey("font_size")
        return FontSizeLevel.entries.find { it.scale.toString() == saved }
    }
}
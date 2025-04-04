package com.f98k.tipstermindcocoapods.domain.bridge

import android.os.VibrationEffect
import android.os.Vibrator
import android.content.Context
import android.os.Build
import androidx.annotation.RequiresPermission
import android.Manifest

actual object VibrationBridge {
    @RequiresPermission(Manifest.permission.VIBRATE)
    actual fun vibrate() {
        val vibrator = appContext.getSystemService(Context.VIBRATOR_SERVICE) as? Vibrator
        vibrator?.let {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                it.vibrate(VibrationEffect.createOneShot(50, VibrationEffect.DEFAULT_AMPLITUDE))
            } else {
                @Suppress("DEPRECATION")
                it.vibrate(50)
            }
        }
    }
}
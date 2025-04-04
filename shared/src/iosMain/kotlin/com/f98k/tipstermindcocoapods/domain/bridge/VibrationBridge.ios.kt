package com.f98k.tipstermindcocoapods.domain.bridge


import platform.AudioToolbox.AudioServicesPlaySystemSound
import platform.AudioToolbox.kSystemSoundID_Vibrate

actual object VibrationBridge {
    actual fun vibrate() {
        AudioServicesPlaySystemSound(kSystemSoundID_Vibrate)
    }
}
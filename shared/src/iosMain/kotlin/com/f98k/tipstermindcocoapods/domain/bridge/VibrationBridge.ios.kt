package com.f98k.tipstermindcocoapods.domain.bridge


import platform.UIKit.UIImpactFeedbackGenerator
import platform.UIKit.UIImpactFeedbackStyle


actual object VibrationBridge {
    actual fun vibrate() {
        val generator = UIImpactFeedbackGenerator(style = UIImpactFeedbackStyle.UIImpactFeedbackStyleLight)
        generator.prepare()
        generator.impactOccurred()
    }
}
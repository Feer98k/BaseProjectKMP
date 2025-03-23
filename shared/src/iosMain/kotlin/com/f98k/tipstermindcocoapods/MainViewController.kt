package com.f98k.tipstermindcocoapods

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.window.ComposeUIViewController
import com.f98k.tipstermindcocoapods.domain.RemoteConfigServiceProvider



fun MainViewController() = ComposeUIViewController(
    configure = {
        val remoteConfig = RemoteConfigServiceProvider.remoteConfigService
        remoteConfig?.getRemoteConfigValue("general_matches_hml") { json ->
            println("Config Json: $json")
        }
    }
) {
    GreetingView("Hello, iOS!")
}

@Composable
fun GreetingView(text: String) {
    Text(text = text)
}
package com.f98k.tipstermindcocoapods

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.window.ComposeUIViewController
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.f98k.tipstermindcocoapods.domain.RemoteConfigServiceProvider
import com.f98k.tipstermindcocoapods.domain.di.initKoin



fun MainViewController() = ComposeUIViewController(
    configure = {
        initKoin()
    }
) {
    GreetingView("Hello, iOS!")
}

@Composable
fun GreetingView(text: String) {
    var jsonReceived by remember { mutableStateOf("JsonVazio") }
    LaunchedEffect(Unit) {
        delay(1000)
        jsonReceived = "vou chamar em 2 segundos"
        delay(2000)
        jsonReceived = "delay finalizado vou chamar agora o remote config"

        val remoteConfig = RemoteConfigServiceProvider.remoteConfigService
        remoteConfig?.getRemoteConfigValue("general_matches_hml") { json ->
            jsonReceived = json?: "JsonRetornando eh nullo"
        }?: run {
            jsonReceived = "RemoteConfigServiceProvider is null"
        }
    }

    Column {
        Text(text = text)
        Spacer(Modifier.height(30.dp))
        Text(text = text)
        Spacer(Modifier.height(30.dp))
        Text(text = jsonReceived)
    }

}
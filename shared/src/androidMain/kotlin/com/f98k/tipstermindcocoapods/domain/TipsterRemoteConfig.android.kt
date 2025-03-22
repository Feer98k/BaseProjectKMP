package com.f98k.tipstermindcocoapods.domain

import android.util.Log
import com.google.firebase.Firebase
import com.google.firebase.remoteconfig.remoteConfig
import com.google.firebase.remoteconfig.remoteConfigSettings


actual class TipsterRemoteConfig actual constructor() {

    actual fun getRemoteConfigValue(key:String ,onFetchCompleted: (String?) -> Unit) {
        val remoteConfig = Firebase.remoteConfig
        val configSettings = remoteConfigSettings {
            minimumFetchIntervalInSeconds = 3600
        }

        remoteConfig.setConfigSettingsAsync(configSettings)

        remoteConfig.setDefaultsAsync(
            mapOf(
                "feature_enabled" to false,
                "welcome_message" to "Hello World!"
            )
        )

        remoteConfig.fetchAndActivate().addOnCompleteListener { task ->
            if (task.isSuccessful) {
                val value = remoteConfig.getString(key)
                Log.d("FirebaseService", "✅ JSON recebido: $value")
                onFetchCompleted(value)
            } else {
                Log.d("FirebaseService", "❌ Falha ao buscar RemoteConfig")
                onFetchCompleted(null)
            }
        }
    }
}
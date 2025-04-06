package com.f98k.baseproject.domain

import com.google.firebase.Firebase
import com.google.firebase.remoteconfig.remoteConfig
import com.google.firebase.remoteconfig.remoteConfigSettings

actual object RemoteConfigServiceProvider {
    actual var remoteConfigService: RemoteConfigService? = AndroidRemoteConfigService()
}

class AndroidRemoteConfigService : RemoteConfigService {

    private val remoteConfig = Firebase.remoteConfig

    override fun getRemoteConfigValue(key: String, onFetchCompleted: (String?) -> Unit) {
        val configSettings = remoteConfigSettings {
            minimumFetchIntervalInSeconds = 0
        }
        remoteConfig.setConfigSettingsAsync(configSettings).addOnCompleteListener {
            remoteConfig
                .fetchAndActivate()
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        val value = remoteConfig.getString(key)
                        onFetchCompleted(value)
                    } else {
                        onFetchCompleted(null)
                    }
                }
        }
    }
}
package com.f98k.tipstermindcocoapods.domain

import com.google.firebase.Firebase
import com.google.firebase.remoteconfig.remoteConfig

actual object RemoteConfigServiceProvider {
    actual var remoteConfigService: RemoteConfigService? = AndroidRemoteConfigService()
}

class AndroidRemoteConfigService : RemoteConfigService {

    private val remoteConfig = Firebase.remoteConfig

    override fun getRemoteConfigValue(key: String, onFetchCompleted: (String?) -> Unit) {
        remoteConfig.fetchAndActivate()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val value = remoteConfig.getString(key)
                    onFetchCompleted(value)
                } else {
                    onFetchCompleted(null)
                }
            }
    }

    private fun resultOrNull(key: String): String? {
        return if (remoteConfig.getValue(key).source != com.google.firebase.remoteconfig.FirebaseRemoteConfig.VALUE_SOURCE_STATIC) {
            remoteConfig.getString(key)
        } else {
            null
        }
    }
}
package com.f98k.tipstermindcocoapods.domain.bridge

import android.content.Context

lateinit var appContext: Context

fun initJsonReader(context: Context) {
    appContext = context.applicationContext
}

actual fun readJsonFileFromAssets(fileName: String): String {
    val json = appContext.assets.open(fileName)
        .bufferedReader()
        .use { it.readText() }
    return json
}
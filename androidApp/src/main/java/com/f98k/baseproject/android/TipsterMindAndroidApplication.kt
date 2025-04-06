package com.f98k.baseproject.android

import android.app.Application
import com.f98k.baseproject.domain.di.initKoin
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.component.KoinComponent

class TipsterMindAndroidApplication : Application(), KoinComponent {

    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidLogger()
            androidContext(this@TipsterMindAndroidApplication)
        }
    }
}
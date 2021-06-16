package com.saeede.searchvideo

import android.app.Application
import com.saeede.searchvideo.core.di.diModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MyApplication:Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidLogger()
            androidContext(this@MyApplication
            )
            modules(diModules)
        }
    }
}
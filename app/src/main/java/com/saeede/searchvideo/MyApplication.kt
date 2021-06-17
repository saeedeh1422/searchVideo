package com.saeede.searchvideo

import android.app.Application
import com.facebook.drawee.backends.pipeline.Fresco
import com.saeede.searchvideo.common.diModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import timber.log.Timber

class MyApplication:Application() {
    override fun onCreate() {
        super.onCreate()
        Fresco.initialize(this)
        Timber.plant(Timber.DebugTree())
        startKoin{
            androidLogger()
            androidContext(this@MyApplication
            )
            modules(diModules)
        }
    }
}
package com.dokapeteam.dokape.android.application

import android.app.Application
import com.dokapeteam.dokape.authentication.di.AuthenticationModule
import com.dokapeteam.dokape.di.initKoin
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.logger.Level

class DokapeApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidContext(this@DokapeApplication)
            androidLogger(level = Level.DEBUG)
            modules(AuthenticationModule)
        }
    }
}

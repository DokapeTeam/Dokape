package com.dokapeteam.dokape.di

import co.touchlab.kermit.LogWriter
import co.touchlab.kermit.LogcatWriter
import org.koin.dsl.module

actual fun platformModules() = module {
    single<LogWriter> { LogcatWriter() }
}

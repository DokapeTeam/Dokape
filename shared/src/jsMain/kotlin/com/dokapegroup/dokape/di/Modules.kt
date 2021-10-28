package com.dokapegroup.dokape.di

import org.koin.dsl.module

actual fun platformModules() = module {
    single {
        DokapeDatabaseWrapper(null)
    }
}

package com.dokapegroup.dokape.di

import com.dokapegroup.DokapeDatabase
import com.dokapegroup.dokape.Constants
import com.dokapegroup.dokape.Pet
import com.dokapegroup.dokape.User
import com.squareup.sqldelight.EnumColumnAdapter
import com.squareup.sqldelight.drivers.native.NativeSqliteDriver
import org.koin.dsl.module

actual fun platformModules() = module {
    single {
        val driver = NativeSqliteDriver(DokapeDatabase.Schema, Constants.DatabaseFileName)
        // Enable Foreign keys for Native SQLite driver
        driver.execute(null, "PRAGMA foreign_keys=ON", 0)
        DokapeDatabaseWrapper(
            DokapeDatabase(
                driver = get(),
                petAdapter = Pet.Adapter(genderAdapter = EnumColumnAdapter()),
                userAdapter = User.Adapter(genderAdapter = EnumColumnAdapter())
            )
        )
    }
}

package com.dokapegroup.dokape.di

import androidx.sqlite.db.SupportSQLiteDatabase
import co.touchlab.kermit.LogWriter
import co.touchlab.kermit.LogcatWriter
import com.dokapegroup.DokapeDatabase
import com.dokapegroup.dokape.Constants
import com.dokapegroup.dokape.DbPet
import com.dokapegroup.dokape.DbUser
import com.squareup.sqldelight.EnumColumnAdapter
import com.squareup.sqldelight.android.AndroidSqliteDriver
import org.koin.dsl.module

actual fun platformModules() = module {
    single {
        AndroidSqliteDriver(
            DokapeDatabase.Schema,
            get(),
            Constants.DatabaseFileName,
            callback = object : AndroidSqliteDriver.Callback(DokapeDatabase.Schema) {
                override fun onOpen(db: SupportSQLiteDatabase) {
                    db.execSQL("PRAGMA foreign_keys=ON;")
                }
            })

        DokapeDatabaseWrapper(
            DokapeDatabase(
                driver = get(),
                dbPetAdapter = DbPet.Adapter(genderAdapter = EnumColumnAdapter()),
                dbUserAdapter = DbUser.Adapter(genderAdapter = EnumColumnAdapter())
            )
        )
    }
    single<LogWriter> { LogcatWriter() }
}

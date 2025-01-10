package database.di

import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import database.data.addMigration
import database.data.createDatabase
import database.data.sqlDriverFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import org.koin.dsl.module
import database.createRoomDatabase

val databaseModule
    get() =
        module {
            factory { addMigration(sqlDriverFactory()) }
            single { createDatabase(driver = get()) }
            single {
                createRoomDatabase()
                    .fallbackToDestructiveMigrationOnDowngrade(dropAllTables = false)
                    .setDriver(BundledSQLiteDriver())
                    .setQueryCoroutineContext(Dispatchers.IO)
                    .build()
            }
        }
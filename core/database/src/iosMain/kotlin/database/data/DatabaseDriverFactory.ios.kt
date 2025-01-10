package database.data

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import database.Database
import org.koin.core.scope.Scope

actual fun Scope.sqlDriverFactory(): SqlDriver =
    NativeSqliteDriver(
        schema = Database.Schema,
        name = DB_NAME,
    )

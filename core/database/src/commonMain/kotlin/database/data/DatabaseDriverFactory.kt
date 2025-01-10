package database.data

import app.cash.sqldelight.db.SqlDriver
import org.koin.core.scope.Scope

internal const val DB_NAME = "database.db"

expect fun Scope.sqlDriverFactory(): SqlDriver

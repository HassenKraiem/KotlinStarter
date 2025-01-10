package database.data

import app.cash.sqldelight.db.QueryResult
import app.cash.sqldelight.db.SqlDriver
import database.Database

private const val VERSION_PRAGMA = "user_version"

fun addMigration(driver: SqlDriver): SqlDriver {
    val oldVersion: Long =
        driver
            .executeQuery(
                identifier = null,
                sql = "PRAGMA $VERSION_PRAGMA",
                mapper = { cursor ->
                    val queryResult = cursor.next()
                    val version =
                        if (queryResult.value) {
                            cursor.getLong(0)
                        } else {
                            null
                        }
                    QueryResult.Value(version)
                },
                parameters = 0,
            ).value ?: 0

    val newVersion = Database.Schema.version

    if (oldVersion == 0L) {
        println("Creating DB version $newVersion!")
        Database.Schema.create(driver)
        driver.execute(null, "PRAGMA $VERSION_PRAGMA=$newVersion", 0)
    } else if (oldVersion < newVersion) {
        println("Migrating DB from version $oldVersion to $newVersion!")
        Database.Schema.migrate(driver, oldVersion, newVersion)
        driver.execute(null, "PRAGMA $VERSION_PRAGMA=$newVersion", 0)
    } else if (oldVersion > newVersion) {
        println("Downgrading DB from version $oldVersion to $newVersion!")
        Database.Schema.create(driver)
        driver.execute(null, "PRAGMA $VERSION_PRAGMA=$newVersion", 0)
    } else {
        println("DB version $oldVersion is up-to-date!")
    }
    return driver
}

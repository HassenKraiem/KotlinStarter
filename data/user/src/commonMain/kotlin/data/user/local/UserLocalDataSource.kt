package data.user.local

import app.cash.sqldelight.coroutines.asFlow
import app.cash.sqldelight.coroutines.mapToList
import data.user.mapper.toUser
import data.user.mapper.toUserEntity
import database.Database
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import domain.user.model.User
import org.koin.core.annotation.Single

@Single
internal class UserLocalDataSource(
    database: Database,
) {
    private val userQueries = database.userEntityQueries

    fun getAllUsers(): List<User> =
        userQueries
            .getAllUsers()
            .executeAsList()
            .map { it.toUser() }

    fun getUserFlow(): Flow<List<User>> =
        userQueries
            .getAllUsers()
            .asFlow()
            .mapToList(Dispatchers.IO)
            .map {
                it.map { userEntity -> userEntity.toUser() }
            }

    fun addUser(user: User) {
        userQueries.insert(user.toUserEntity())
    }

    fun updateUser(user: User) {
        userQueries.update(
            user.firstName,
            user.lastName,
            user.age.toLong(),
            user.birthDate,
        )
    }

    fun deleteUser(
        lastName: String,
        firstName: String,
    ) {
        userQueries.delete(lastName, firstName)
    }
}

package data.user.repository

import data.user.local.UserLocalDataSource
import domain.user.model.User
import domain.user.repository.UserRepository
import org.koin.core.annotation.Single

@Single
internal class UserRepositoryImpl(
    private val usersLocalDataSource: UserLocalDataSource,
) : UserRepository {
    override suspend fun addUser(user: User) =
        runCatching {
            usersLocalDataSource.addUser(user)
        }

    override suspend fun deleteUser(user: User) =
        runCatching {
            usersLocalDataSource.deleteUser(user.lastName, user.firstName)
        }

    override suspend fun updateUser(user: User) =
        runCatching {
            usersLocalDataSource.updateUser(user)
        }

    override suspend fun getUsers() =
        runCatching {
            usersLocalDataSource.getAllUsers()
        }

    override suspend fun getUserFlow() =
        runCatching {
            usersLocalDataSource.getUserFlow()
        }
}

package domain.user.repository

import kotlinx.coroutines.flow.Flow
import domain.user.model.User

interface UserRepository {
    suspend fun addUser(user: User): Result<Unit>

    suspend fun deleteUser(user: User): Result<Unit>

    suspend fun updateUser(user: User): Result<Unit>

    suspend fun getUsers(): Result<List<User>>

    suspend fun getUserFlow(): Result<Flow<List<User>>>
}

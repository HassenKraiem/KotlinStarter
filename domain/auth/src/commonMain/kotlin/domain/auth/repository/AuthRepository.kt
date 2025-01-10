package domain.auth.repository

import domain.auth.model.User

interface AuthRepository {
    suspend fun login(
        email: String,
        password: String,
    ): Result<User>

    suspend fun signUp(newUser: User): Result<User>
}

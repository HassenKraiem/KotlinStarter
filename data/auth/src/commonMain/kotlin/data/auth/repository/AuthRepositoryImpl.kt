package data.auth.repository

import data.auth.remote.AuthRemoteDataSource
import data.auth.remote.request.toSignUpRequest
import domain.auth.model.User
import domain.auth.repository.AuthRepository
import org.koin.core.annotation.Single

@Single
internal class AuthRepositoryImpl(
    private val remote: AuthRemoteDataSource,
) : AuthRepository {
    override suspend fun login(
        email: String,
        password: String,
    ): Result<User> =
        runCatching {
            remote
                .login(
                    emailOrPhoneNb = email,
                    password = password,
                ).data
                .toModel()
        }

    override suspend fun signUp(newUser: User): Result<User> =
        runCatching {
            remote.signup(
                signUpRequest = newUser.toSignUpRequest(),
            )
        }
}

package data.auth.remote

import data.auth.remote.request.SignUpRequest
import data.auth.remote.response.LoginResponse
import domain.auth.model.User
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.statement.HttpResponse
import io.ktor.http.ContentType
import io.ktor.http.contentType
import network.data.TokenSettings
import network.di.NO_AUTH
import network.helper.handleErrors
import org.koin.core.annotation.Named
import org.koin.core.annotation.Single

@Single
internal class AuthRemoteDataSource(
    @Named(NO_AUTH) private val noAuthClient: HttpClient,
    private val settings: TokenSettings,
) {
    suspend fun login(
        emailOrPhoneNb: String,
        password: String,
    ): LoginResponse =
        handleErrors<LoginResponse> {
            val response: HttpResponse =
                noAuthClient.post(urlString = LOGIN_URL) {
                    setBody(
                        hashMapOf(
                            "email" to emailOrPhoneNb,
                            "password" to password,
                        ),
                    )
                }

            val result = response.body<LoginResponse>()
            settings.accessToken = result.data?.tokens?.accessToken ?: ""
            settings.refreshToken = result.data?.tokens?.refreshToken ?: ""

            return@handleErrors response
        }

    suspend fun signup(signUpRequest: SignUpRequest): User =
        handleErrors<User> {
            noAuthClient.post(urlString = "") {
                contentType(ContentType.Application.Json)
                setBody(
                    signUpRequest,
                )
            }
        }

    companion object {
        const val LOGIN_URL = "auth/login"
    }
}

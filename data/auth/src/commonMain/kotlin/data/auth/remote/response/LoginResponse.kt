package data.auth.remote.response

import domain.auth.model.User
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import network.domain.Token

@Serializable
data class LoginResponse(
    val data: Data,
)

@Serializable
data class Data(
    val tokens: Tokens,
    val user: UserDto,
) {
    fun toModel() =
        user.toUserModel()
}

@Serializable
data class Tokens(
    val accessToken: String,
    val refreshToken: String,
) {
    fun toToken() =
        Token(
            accessToken = accessToken,
            refreshToken = refreshToken,
        )
}

@Serializable
data class UserDto(
    @SerialName("_id") val id: String,
    val documentVerified: Boolean? = null,
    val email: String? = null,
    val firstName: String? = null,
    val isBanned: Boolean? = null,
    val lastName: String? = null,
    val profilePicUrl: String? = null,
    val userType: UserType? = null,
    val verified: Boolean? = null,
) {
    fun toUserModel() =
        User(
            id = id,
            firstName = firstName.orEmpty(),
            lastName = lastName.orEmpty(),
            profilePicUrl = profilePicUrl.orEmpty(),
            userType = userType?.name.orEmpty(),
            email = email.orEmpty(),
        )
}

@Serializable
data class UserType(
    @SerialName("_id") val id: String? = null,
    val name: String? = null,
)

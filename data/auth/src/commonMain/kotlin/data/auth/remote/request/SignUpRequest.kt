package data.auth.remote.request

import domain.auth.model.User
import kotlinx.serialization.Serializable

@Serializable
data class SignUpRequest(
    val firstName: String,
    val lastName: String,
    val email: String? = null,
    val phoneNumber: String? = null,
    val password: String,
    val userType: String,
    val country: String,
    val birthDay: String,
    val gender: String,
    val confirmationType: String,
)

fun User.toSignUpRequest() =
    SignUpRequest(
        firstName = firstName,
        lastName = lastName,
        email = email,
        birthDay = "",
        password = "",
        userType = "",
        confirmationType = "",
        gender = "",
        country = "",
    )
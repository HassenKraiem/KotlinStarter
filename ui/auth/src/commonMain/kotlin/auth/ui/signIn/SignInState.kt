package auth.ui.signIn

import domain.auth.model.User

data class SignInState(
    val id: String,
    val email: String = "",
    val profilePicUrl: String? = null,
    val userType: String = "",
    val firstName: String = "",
    val lastName: String = "",
) {
    fun toUser() =
        User(
            id,
            email,
            profilePicUrl,
            userType,
            firstName,
            lastName,
        )
}

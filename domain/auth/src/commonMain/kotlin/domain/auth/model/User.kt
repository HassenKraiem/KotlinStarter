package domain.auth.model

data class User(
    val id: String,
    val email: String,
    val profilePicUrl: String?,
    val userType: String,
    val firstName: String,
    val lastName: String,
)

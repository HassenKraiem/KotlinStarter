package auth.ui.login

sealed interface LoginEvent {
    data class Login(val email: String, val password: String) : LoginEvent
}
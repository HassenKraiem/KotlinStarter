package auth.ui.login

import domain.auth.model.User
import utils.viewmodel.State

val Loading: Nothing? = null

data class LoginState(
    val login: State<User> = State(),
    val error: String? = Loading,
)

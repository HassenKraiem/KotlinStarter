package navigation.auth.login

import auth.ui.login.LoginEvent
import auth.ui.login.LoginState
import auth.ui.login.LoginViewModel
import cafe.adriel.voyager.core.model.StateScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import domain.auth.repository.AuthRepository
import org.koin.core.annotation.Factory

@Factory
class LoginScreenModel(
    loginRepository: AuthRepository,
) : StateScreenModel<LoginState>(LoginState()) {
    private val viewModel =
        LoginViewModel(
            repository = loginRepository,
            scope = screenModelScope,
            state = mutableState,
        )

    fun onEvent(event: LoginEvent) = viewModel.onEvent(event)
}

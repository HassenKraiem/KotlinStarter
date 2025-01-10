package auth.ui.login

import domain.auth.repository.AuthRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import utils.viewmodel.ViewModel
import utils.viewmodel.getData

class LoginViewModel(
    private val repository: AuthRepository,
    override val scope: CoroutineScope,
    private val state: MutableStateFlow<LoginState>,
) : ViewModel {

    fun onEvent(event: LoginEvent) {
        when (event) {
            is LoginEvent.Login -> onLogin(event)
        }
    }

    fun onLogin(event: LoginEvent.Login) =
        getData(
            getData = {
                repository.login(
                    email = event.email,
                    password = event.password,
                )
            },
            getState = { state.value.login },
            setState = { newState -> state.update { it.copy(login = newState) } },
            onFailure = { exception ->
                state.value =
                    state.value.copy(
                        error = exception.message ?: "Unknown Error",
                    )
            },
        )
}

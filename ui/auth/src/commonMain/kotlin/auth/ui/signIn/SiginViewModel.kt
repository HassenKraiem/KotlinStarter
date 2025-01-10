package auth.ui.signIn

import domain.auth.repository.AuthRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class SignViewModel(
    private val repository: AuthRepository,
    private val scope: CoroutineScope,
    val state: MutableStateFlow<SignInState>,
) {
    fun signIn() {
        scope.launch {
            repository.signUp(state.value.toUser())
        }
    }
}

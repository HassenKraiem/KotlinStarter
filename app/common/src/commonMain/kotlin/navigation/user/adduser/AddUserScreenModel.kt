package navigation.user.adduser

import cafe.adriel.voyager.core.model.StateScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import domain.user.repository.UserRepository
import org.koin.core.annotation.Factory
import user.ui.user.UserEvent
import user.ui.user.UserState
import user.ui.user.UserViewModel

@Factory
class AddUserScreenModel(
    userRepository: UserRepository,
) : StateScreenModel<UserState>(UserState()) {
    private val userViewModel =
        UserViewModel(
            userRepository = userRepository,
            scope = screenModelScope,
            state = mutableState,
        )

    fun onEvent(event: UserEvent) {
        userViewModel.onEvent(event)
    }
}

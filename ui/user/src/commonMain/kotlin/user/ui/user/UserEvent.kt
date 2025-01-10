package user.ui.user

import domain.user.model.User

sealed class UserEvent {
    data class AddUser(
        val user: User,
    ) : UserEvent()

    data class PickBirthDate(
        val date: Long,
    ) : UserEvent()
}

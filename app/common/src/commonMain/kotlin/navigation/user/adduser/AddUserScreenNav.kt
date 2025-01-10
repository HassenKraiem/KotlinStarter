package navigation.user.adduser

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.getScreenModel
import user.ui.user.UserScreen

class AddUserScreenNav : Screen {
    @Composable
    override fun Content() {
        val addUserScreenModel = getScreenModel<AddUserScreenModel>()

        val state = addUserScreenModel.state.collectAsState()

        UserScreen(
            state = state.value,
            onEvent = addUserScreenModel::onEvent,
        )
    }
}

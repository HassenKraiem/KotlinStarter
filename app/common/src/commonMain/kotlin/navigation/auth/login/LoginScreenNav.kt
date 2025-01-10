package navigation.auth.login

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import auth.ui.login.LoginScreen
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.getScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import navigation.auth.navigation.onNavigate

class LoginScreenNav : Screen {
    @Composable
    override fun Content() {
        val loginScreenModel = getScreenModel<LoginScreenModel>()
        val state = loginScreenModel.state.collectAsState()

        val navigator = LocalNavigator.currentOrThrow

        LoginScreen(
            state = state.value,
            onEvent = loginScreenModel::onEvent,
            onNavigation = { navigator.onNavigate(it) },
        )
    }
}

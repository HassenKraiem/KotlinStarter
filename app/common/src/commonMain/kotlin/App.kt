import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import core.ui.theme.KotlinStarterTheme
import navigation.auth.login.LoginScreenNav

@Composable
fun App() {
    KotlinStarterTheme {
        Navigator(LoginScreenNav())
    }
}

package navigation.auth.navigation

import auth.ui.navigation.AuthNavigation
import cafe.adriel.voyager.navigator.Navigator
import navigation.auth.login.LoginScreenNav
import navigation.user.adduser.AddUserScreenNav

internal fun Navigator.onNavigate(authScreen: AuthNavigation) {
    when (authScreen) {
        is AuthNavigation.Login -> push(LoginScreenNav())
        is AuthNavigation.Out -> push(AddUserScreenNav())
        is AuthNavigation.SignUp -> {}
        is AuthNavigation.SplashScreen -> {}
    }
}
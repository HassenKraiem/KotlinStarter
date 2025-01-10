package auth.ui.navigation

sealed class AuthNavigation {
    data object SplashScreen : AuthNavigation()

    data object Login : AuthNavigation()

    data object SignUp : AuthNavigation()

    data object Out : AuthNavigation()
}

package utils.navigation

sealed class AuthNavigation {
    data object RecipeListScreen : AuthNavigation()

    data object RecipeDetailsScreen : AuthNavigation()
    data object SplashScreen : AuthNavigation()

    data object Login : AuthNavigation()

    data object SignUp : AuthNavigation()

    data object Out : AuthNavigation()
}

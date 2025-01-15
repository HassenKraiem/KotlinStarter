package navigation.auth.navigation

import cafe.adriel.voyager.navigator.Navigator
import navigation.auth.login.LoginScreenNav
import navigation.recipeDetails.RecipeDetailsScreenNav
import navigation.recipeList.RecipeListScreenNav
import navigation.user.adduser.AddUserScreenNav
import utils.navigation.AuthNavigation

internal fun Navigator.onNavigate(authScreen: AuthNavigation) {
    when (authScreen) {
        is AuthNavigation.Login -> push(LoginScreenNav())
        is AuthNavigation.Out -> push(AddUserScreenNav())
        is AuthNavigation.SignUp -> {}
        is AuthNavigation.SplashScreen -> {}
        is AuthNavigation.RecipeDetailsScreen -> push(RecipeDetailsScreenNav())
        is AuthNavigation.RecipeListScreen -> push(RecipeListScreenNav())
    }
}
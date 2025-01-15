package navigation

import cafe.adriel.voyager.navigator.Navigator
import navigation.recipeDetails.RecipeDetailsScreenNav
import navigation.recipeList.RecipeListScreenNav
import utils.navigation.AuthNavigation

internal fun Navigator.onNavigate(authScreen: AuthNavigation) {
    when (authScreen) {
        is AuthNavigation.RecipeDetailsScreen -> push(RecipeDetailsScreenNav(id = authScreen.id))
        is AuthNavigation.RecipeListScreen -> push(RecipeListScreenNav())
    }
}
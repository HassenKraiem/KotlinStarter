package utils.navigation

sealed interface AuthNavigation {
    data object RecipeListScreen : AuthNavigation

    data class RecipeDetailsScreen(val id:String) : AuthNavigation
}

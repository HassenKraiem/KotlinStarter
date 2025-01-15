package navigation.recipeList

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.getScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import navigation.auth.navigation.onNavigate
import navigation.recipeDetails.RecipeDetailsScreenModel
import ui.details.RecipeDetailsScreen
import ui.recipe_list.RecipeListScreen

class RecipeListScreenNav():Screen {
    @Composable
    override fun Content() {
        val recipeListScreenModel = getScreenModel<RecipeListScreenModel>()
        val state = recipeListScreenModel.state.collectAsState()
        val navigator = LocalNavigator.currentOrThrow
        RecipeListScreen(
            state = state.value,
            onEvent = recipeListScreenModel::onEvent,
            onNavigation = { navigator.onNavigate(it) },
        )
    }
}
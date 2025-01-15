package navigation.recipeDetails

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import auth.ui.login.LoginScreen
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.getScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import navigation.auth.login.LoginScreenModel
import navigation.auth.navigation.onNavigate
import ui.details.RecipeDetailsScreen

class RecipeDetailsScreenNav : Screen {
        @Composable
        override fun Content() {
            val detailsScreenModel = getScreenModel<RecipeDetailsScreenModel>()
            val state = detailsScreenModel.state.collectAsState()
            val navigator = LocalNavigator.currentOrThrow
            RecipeDetailsScreen(
                state = state.value,
                onEvent = detailsScreenModel::onEvent,
                onNavigation = { navigator.onNavigate(it) },
            )
        }
}
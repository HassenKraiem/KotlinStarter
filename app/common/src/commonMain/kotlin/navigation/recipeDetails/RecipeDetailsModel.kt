package navigation.recipeDetails

import auth.ui.login.LoginEvent
import auth.ui.login.LoginState
import auth.ui.login.LoginViewModel
import cafe.adriel.voyager.core.model.StateScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import domain.recipe.details.repository.RecipeDetailsRepository
import org.koin.core.annotation.Factory
import ui.details.RecipeDetailsEvent
import ui.details.RecipeDetailsState
import ui.details.RecipeDetailsViewModel

@Factory
class RecipeDetailsScreenModel(
    loginRepository: RecipeDetailsRepository,
) : StateScreenModel<RecipeDetailsState>(RecipeDetailsState()) {
    private val viewModel =
        RecipeDetailsViewModel(
            repository = loginRepository,
            scope = screenModelScope,
            state = mutableState,
        )

    fun onEvent(event: RecipeDetailsEvent) = viewModel.onEvent(event)
}

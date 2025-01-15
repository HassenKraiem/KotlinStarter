package navigation.recipeList

import RecipeListEvent
import RecipeListViewModel
import cafe.adriel.voyager.core.model.StateScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import domain.recipe.repository.RecipeRepository
import org.koin.core.annotation.Factory
import ui.recipe_list.RecipeState

@Factory
class RecipeListScreenModel(
    repository: RecipeRepository,
) : StateScreenModel<RecipeState>(RecipeState()) {
    private val viewModel =
        RecipeListViewModel(
            repository = repository,
            scope = screenModelScope,
            state = mutableState,
        )

    fun onEvent(event: RecipeListEvent) = viewModel.onEvent(event)
}
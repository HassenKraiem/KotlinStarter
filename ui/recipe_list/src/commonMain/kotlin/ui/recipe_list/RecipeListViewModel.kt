
import domain.recipe.repository.RecipeRepository
import ui.recipe_list.RecipeState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import utils.viewmodel.ViewModel
import utils.viewmodel.getData


class RecipeListViewModel(
    private val repository: RecipeRepository,
    override val scope: CoroutineScope,
    private val state: MutableStateFlow<RecipeState>,
): ViewModel {

    fun onEvent(event: RecipeListEvent) {
        when (event) {
            is RecipeListEvent.RecipeList->search(q = event.searchQuery)
            else -> {}
        }
    }

    fun search(q: String) =
        getData(
            getData = { repository.getRecipes(searchQuery = q) },
            getState = { state.value.meal },
            setState = { newState -> state.update { it.copy(meal = newState) } },
            onFailure = { exception ->
                state.value =
                    state.value.copy(
                        error = exception.message ?: "Unknown Error",
                    )
            }
        )
}
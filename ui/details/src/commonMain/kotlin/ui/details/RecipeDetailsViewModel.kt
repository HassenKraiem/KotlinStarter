package ui.details

import domain.recipe.details.repository.RecipeDetailsRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import utils.viewmodel.ViewModel
import utils.viewmodel.getData

class RecipeDetailsViewModel(
    private val repository: RecipeDetailsRepository,
    override val scope: CoroutineScope,
    private val state: MutableStateFlow<RecipeDetailsState>,
) : ViewModel {

    fun onEvent(event: RecipeDetailsEvent) {
        when (event) {
            is RecipeDetailsEvent.RecipeDetails -> getRecipeDetails(id = event.id)

        }
    }

    fun getRecipeDetails(id: String) = getData(
        getData = { repository.getRecipeDetails(id) },
        getState = { state.value.recipeDetails },
        setState = { newState ->
            println(newState)
            state.update {
                it.copy(
                    recipeDetails = newState
                )
            }
        },
        onFailure = { exception ->
            state.value = state.value.copy(
                error = exception.message ?: "Unknown Error",
            )
        },
    )

}
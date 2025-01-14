package ui.details

import domain.recipe.details.model.RecipeDetails
import utils.viewmodel.State

data class RecipeDetailsState(
    val recipeDetails: State<RecipeDetails> = State(),
    val error: String? = null
)

/**
 * user: User
 * getUser: State<User>
 */

/**
 *
 */
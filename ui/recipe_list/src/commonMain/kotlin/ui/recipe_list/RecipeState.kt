package ui.recipe_list



import domain.recipe.model.Recipe
import utils.viewmodel.State

data class RecipeState(
    val recipe:State<List<Recipe>> = State(),
    val error: String?= null
) {
}

package ui.recipe_list



import Recipe
import domain.recipe.model.Meal
import domain.recipe.model.RecipeModel
import utils.viewmodel.State

data class RecipeState(
    val meal:State<RecipeModel> = State(),
    val error: String?= null
) {
}

package domain.recipe.repository

import domain.recipe.model.Meal
import domain.recipe.model.RecipeModel

interface RecipeRepository {
    suspend fun getRecipes(searchQuery:String):Result<RecipeModel>
}
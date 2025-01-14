package domain.recipe.repository

import domain.recipe.model.Recipe

interface RecipeRepository {
    suspend fun getRecipes(searchQuery:String):Result<List<Recipe>>
}
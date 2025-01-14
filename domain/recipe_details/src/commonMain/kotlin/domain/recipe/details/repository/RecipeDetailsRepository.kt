package domain.recipe.details.repository

import domain.recipe.details.model.RecipeDetails

interface RecipeDetailsRepository {
    suspend fun getRecipeDetails(id:String):Result<RecipeDetails>
}
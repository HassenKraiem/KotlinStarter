package com.example.recipe.repository

import com.example.recipe.model.Recipe
import com.example.recipe.model.RecipeDetails

interface RecipeRepository {
    suspend fun getRecipes(searchQuery:String):Result<List<Recipe>>
    suspend fun getRecipeDetails(id:String):Result<RecipeDetails>
}
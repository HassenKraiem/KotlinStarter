package com.example.recipe_response.model

import com.example.recipe.model.RecipeDto
import kotlinx.serialization.Serializable

@Serializable
data class RecipeResponse(
    val recipeDtos: List<RecipeDto>?= null
)
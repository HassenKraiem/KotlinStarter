package data.recipe.model

import kotlinx.serialization.Serializable

@Serializable
data class RecipeDTOX(
    val meals: List<MealDTO>
)
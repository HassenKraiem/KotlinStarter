package com.example.recipe.model

data class RecipeDetails(
    val idMeal: String,
    val strMeal: String,
    val strArea: String,
    val strInstructions: String,
    val strMealThumb: String,
    val strYoutube: String,
    val strTags: String,
    val strCategory: String,
    val ingredientsPair:List<Pair<String,String>>

    )

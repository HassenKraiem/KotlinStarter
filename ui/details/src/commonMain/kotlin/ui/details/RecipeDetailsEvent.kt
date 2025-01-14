package ui.details

sealed interface RecipeDetailsEvent {
    data class RecipeDetails(val id:String): RecipeDetailsEvent
}
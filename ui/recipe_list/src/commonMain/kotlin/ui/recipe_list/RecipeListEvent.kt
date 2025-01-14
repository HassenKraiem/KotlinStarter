sealed interface RecipeListEvent {
    data class RecipeList(val searchQuery:String):RecipeListEvent
}
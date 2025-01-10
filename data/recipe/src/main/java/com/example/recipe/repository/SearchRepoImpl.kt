package com.example.recipe.repository

import com.example.recipe.mapper.toDomain
import com.example.recipe.model.Recipe
import com.example.recipe.model.RecipeDetails
import com.example.recipe.remote.RemoteDataSource
import org.koin.core.annotation.Single


@Single
class SearchRepoImpl(
    private val remoteDataSource: RemoteDataSource
):RecipeRepository {
    override suspend fun getRecipes(searchQuery:String): Result<List<Recipe>> {
        //+-
        return kotlin.runCatching {
            remoteDataSource.getRecipes(searchQuery).
            toDomain()
            }
        }

    override suspend fun getRecipeDetails(id: String): Result<RecipeDetails> {
        return runCatching {
            remoteDataSource.getRecipeDetails(id).
            toDomain()
            }
        }
}
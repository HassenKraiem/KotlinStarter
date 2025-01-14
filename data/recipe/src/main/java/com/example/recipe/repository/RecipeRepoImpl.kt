package com.example.recipe.repository

import com.example.recipe.mapper.toDomain
import domain.recipe.model.Recipe
import com.example.recipe.remote.RemoteDataSource
import domain.recipe.repository.RecipeRepository
import org.koin.core.annotation.Single


@Single
class RecipeRepoImpl(
    private val remoteDataSource: RemoteDataSource
): RecipeRepository {
    override suspend fun getRecipes(searchQuery:String): Result<List<Recipe>> {
        //+-
        return kotlin.runCatching {
            remoteDataSource.getRecipes(searchQuery).
            toDomain()
            }
        }


}
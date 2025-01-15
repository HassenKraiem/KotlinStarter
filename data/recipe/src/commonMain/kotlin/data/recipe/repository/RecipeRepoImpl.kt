package data.recipe.repository

import data.recipe.mapper.toDomain
import domain.recipe.model.Meal
import data.recipe.remote.RemoteDataSource
import domain.recipe.model.RecipeModel
import domain.recipe.repository.RecipeRepository
import org.koin.core.annotation.Single


@Single
class RecipeRepoImpl(
    private val remoteDataSource: RemoteDataSource
): RecipeRepository {
    override suspend fun getRecipes(searchQuery:String): Result<RecipeModel> {
        //+-
        return kotlin.runCatching {
            remoteDataSource.getRecipes(searchQuery).
            toDomain()
            }
        }


}
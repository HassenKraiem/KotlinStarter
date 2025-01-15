package data.recipe.repository

import data.recipe.mapper.toDomain
import data.recipe.remote.RemoteDataSource
import domain.recipe.details.model.RecipeDetails
import domain.recipe.details.repository.RecipeDetailsRepository

class RecipeDetailsRepoImpl(
    private val remoteDataSource: RemoteDataSource
): RecipeDetailsRepository {
    override suspend fun getRecipeDetails(id: String): Result<RecipeDetails> {
        return runCatching {
            remoteDataSource.getRecipeDetails(id).
            toDomain()
        }
    }

}
package data.recipe.repository

import data.recipe.mapper.toDomain2
import data.recipe.remote.RemoteDataSource
import domain.recipe.details.model.RecipeDetails
import domain.recipe.details.repository.RecipeDetailsRepository
import org.koin.core.annotation.Single

@Single
class RecipeDetailsRepoImpl(
    private val remoteDataSource: RemoteDataSource
): RecipeDetailsRepository {
    override suspend fun getRecipeDetails(id: String): Result<RecipeDetails> {
        println("this is ${remoteDataSource.getRecipeDetails(id).meals.first().idMeal.toString()}")
        return runCatching {
            remoteDataSource.getRecipeDetails(id).
            toDomain2()
        }

    }

}
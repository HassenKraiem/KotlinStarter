package data.recipe.remote

import data.recipe.model.RecipeDto
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import network.di.NO_AUTH
import network.helper.handleErrors
import org.koin.core.annotation.Named
import org.koin.core.annotation.Single


@Single
class RemoteDataSource(
    @Named(NO_AUTH) private val noAuthClient: HttpClient,
) {
    suspend fun getRecipes(searchQuery:String): List<RecipeDto> {
        return handleErrors<List<RecipeDto>> {
            noAuthClient.get("api/json/v1/1/search.php") {
                parameter("s", searchQuery)
            }
        }


    }
    suspend fun getRecipeDetails(id:String): RecipeDto {
       return handleErrors<RecipeDto> {
           noAuthClient.get("api/json/v1/1/lookup.php") {
               parameter("i", id)
           }
       }

    }


}
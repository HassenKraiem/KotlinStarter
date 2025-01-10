package com.example.recipe.remote

import com.example.recipe.model.RecipeDto
import domain.auth.model.User
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.statement.HttpResponse
import io.ktor.http.ContentType
import io.ktor.http.contentType
import network.data.TokenSettings
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
    suspend fun getRecipeDetails(id:String):  RecipeDto {
       return handleErrors<RecipeDto> {
           noAuthClient.get("api/json/v1/1/lookup.php") {
               parameter("i", id)
           }
       }

    }


}
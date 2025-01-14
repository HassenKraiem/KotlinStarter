package ui.details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import utils.getIngredientsImageUrl

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecipeDetailsScreen(
    modifier: Modifier=Modifier,
    state: RecipeDetailsState,
    onEvent: (RecipeDetailsEvent)->Unit
){
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = state.recipeDetails.data?.strMeal?:"",
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
            )
        }
    ) {innerPadding->
        if(state.recipeDetails.isLoading){
            Box(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ){
                CircularProgressIndicator()
            }
        }
        if (state.recipeDetails.isFailure){
            Box(
                modifier =Modifier
                    .padding(innerPadding)
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ){
                Text(
                    text = state.error.toString()
                )
            }
        }
        state.recipeDetails.data?.let {recipeDetails ->
            AsyncImage(
                model = recipeDetails.strMealThumb,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
            )
            Spacer(
                modifier=Modifier
                    .height(24.dp)
            )
            Text(
                text = recipeDetails.strInstructions,
                style = MaterialTheme.typography.bodyMedium
            )
            Spacer(
                modifier = Modifier.height(12.dp)
            )
            recipeDetails.ingredientsPair.forEach {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 12.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    AsyncImage(
                        model = getIngredientsImageUrl(it.first),
                        contentDescription = null,
                        modifier = Modifier.background(
                            color = Color.White,
                            shape = CircleShape
                        )
                            .clip(CircleShape)
                    )
                    Text(
                        text = it.second,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
            Spacer(
                modifier=Modifier
                    .height(12.dp)
            )
            Text(
                text = "Watch Youtube Video",
                style = MaterialTheme.typography.bodySmall
            )
            Spacer(
                modifier = Modifier
                    .height(32.dp)
            )

        }

    }
}
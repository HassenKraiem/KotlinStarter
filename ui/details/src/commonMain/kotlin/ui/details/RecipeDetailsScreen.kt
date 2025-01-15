package ui.details

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import utils.getIngredientsImageUrl
import utils.navigation.AuthNavigation

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecipeDetailsScreen(
    modifier: Modifier=Modifier,
    state: RecipeDetailsState,
    onEvent: (RecipeDetailsEvent)->Unit,
    onNavigation:(AuthNavigation)->Unit,
    id:String
){
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = state.recipeDetails.data?.strMeal?:"",
                        style = MaterialTheme.typography.bodyLarge
                    )
                },
                navigationIcon = {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = null,
                        modifier = Modifier
                            .clickable {

                            }
                    )
                },
                actions = {
                    IconButton(onClick = {}) {
                        Icon(
                            imageVector = Icons.Default.Star,
                            contentDescription = null
                        )
                    }
                    IconButton(onClick = {}){
                        Icon(
                            imageVector = Icons.Default.Delete,
                            contentDescription = null
                        )
                    }
                }
            )
        },
    ) { innerPadding ->
        LaunchedEffect(Unit) {
            onEvent(RecipeDetailsEvent.RecipeDetails(id))
        }
        if (state.recipeDetails.isLoading) {
            Box(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }
        if (state.recipeDetails.isFailure) {
            Box(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = state.error.toString()
                )
            }
        }
        if (state.recipeDetails.isSuccess) {
            val scrollState = rememberScrollState()
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .verticalScroll(scrollState),
            ) {
                state.recipeDetails.data?.let { recipeDetails ->
                    AsyncImage(
                        model = recipeDetails.strMealThumb,
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(350.dp),
                        contentScale = ContentScale.Crop
                    )
                    Column(
                        modifier = Modifier
                            .padding(
                                horizontal = 16.dp,
                                vertical = 12.dp
                            )

                    ) {
                        Spacer(
                            modifier = Modifier
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
                            if (it.first.isNotEmpty() && it.second.isNotEmpty()) {
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(
                                            horizontal = 12.dp,
                                            vertical = 12.dp
                                        ),
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    AsyncImage(
                                        model = getIngredientsImageUrl(it.first),
                                        contentDescription = null,
                                        modifier = Modifier
                                            .height(100.dp)
                                            .width(100.dp)
                                            .background(
                                            color = Color.White,
                                            shape = CircleShape
                                        )
                                            .clip(CircleShape)
                                    )
                                    Text(
                                        text = it.second,
                                        style = MaterialTheme.typography.bodyMedium,
                                        fontSize = 30.sp
                                    )
                                }
                            }
                        }

                        Spacer(
                            modifier = Modifier
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
        }
    }
}
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import core.ui.theme.KotlinStarterTheme
import navigation.recipeList.RecipeListScreenNav

@Composable
fun App() {
    KotlinStarterTheme {
        Navigator(RecipeListScreenNav())
    }
}

package navigation.recipeDetails

import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val DetailsModule
    get() = module {
        factoryOf(::RecipeDetailsScreenModel)
    }
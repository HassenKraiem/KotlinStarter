package navigation.recipeList

import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val RecipeListModule
    get() = module {
        factoryOf(::RecipeListScreenModel)
    }
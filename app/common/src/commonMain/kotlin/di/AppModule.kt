package di


import data.recipe.di.DataRecipeModule
import database.di.databaseModule
import navigation.di.NavModule
import network.di.networkModule
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration
import org.koin.ksp.generated.module

fun initKoin(appDeclaration: KoinAppDeclaration) {
    startKoin {
        appDeclaration()
        modules(appModules)
    }
}

val appModules =
    listOf(
        // Core
        networkModule,
        databaseModule,

        // Data
        DataRecipeModule.module,

        // Domain (Use cases)

        // Ui
        NavModule.module
    )

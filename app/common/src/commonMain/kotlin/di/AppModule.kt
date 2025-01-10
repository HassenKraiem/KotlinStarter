package di

import data.auth.di.DataAuthModule
import data.user.di.DataUserModule
import database.di.databaseModule
import navigation.auth.authModule
import navigation.di.NavModule
import navigation.user.userModule
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
        DataAuthModule.module,
        DataUserModule.module,

        // Domain (Use cases)

        // Ui
        NavModule.module,
        authModule,
        userModule
    )

package navigation.auth

import navigation.auth.login.LoginScreenModel
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val authModule
    get() = module {
        factoryOf(::LoginScreenModel)
    }
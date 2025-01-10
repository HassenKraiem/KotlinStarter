package navigation.user

import navigation.user.adduser.AddUserScreenModel
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val userModule
    get() = module {
        factoryOf(::AddUserScreenModel)
    }
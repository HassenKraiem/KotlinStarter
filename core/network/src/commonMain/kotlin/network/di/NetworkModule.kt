package network.di

import com.russhwolf.settings.Settings
import network.createAuthHttpClient
import network.createNoAuthHttpClient
import network.data.TokenSettings
import network.data.TokenSettingsImpl
import org.koin.core.qualifier.named
import org.koin.dsl.module

val networkModule
    get() =
        module {
            single { Settings() }
            single<TokenSettings> { TokenSettingsImpl(get()) }
            single(named(NO_AUTH)) { createNoAuthHttpClient() }
            single(named(AUTH)) { createAuthHttpClient(get(named(NO_AUTH)), get()) }
        }

const val TOKEN_SETTINGS = "TokenSettings"

const val NO_AUTH = "NoAuth"
const val AUTH = "Auth"

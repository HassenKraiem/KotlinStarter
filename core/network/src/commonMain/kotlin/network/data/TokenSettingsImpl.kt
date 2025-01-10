package network.data

import com.russhwolf.settings.Settings

internal class TokenSettingsImpl(
    private val settings: Settings,
) : TokenSettings {
    override var accessToken
        get() = settings.getStringOrNull(ACCESS_TOKEN).orEmpty()
        set(value) {
            value.let { settings.putString(ACCESS_TOKEN, it) }
        }

    override var refreshToken
        get() = settings.getStringOrNull(REFRESH_TOKEN).orEmpty()
        set(value) {
            value.let { settings.putString(REFRESH_TOKEN, it) }
        }

    override fun clear() {
        settings.putString(ACCESS_TOKEN, "")
        settings.putString(REFRESH_TOKEN, "")
    }

    companion object {
        private const val ACCESS_TOKEN = "AccessToken"
        private const val REFRESH_TOKEN = "RefreshToken"
    }
}

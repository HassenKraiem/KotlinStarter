package network.data

interface TokenSettings {
    var accessToken: String

    var refreshToken: String

    fun clear()
}

package network

import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.*

internal actual fun createPlatformHttpClient(): HttpClient = HttpClient(OkHttp)

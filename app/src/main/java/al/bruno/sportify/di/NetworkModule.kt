package al.bruno.sportify.di

import al.bruno.sportify.interceptor.Token
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.ANDROID
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.headers
import io.ktor.http.URLProtocol
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.dsl.module

val networkModule = module {
    single<Token> { Token("") }
    single<HttpClient> { ktorHttpClient(get()) }
}

fun ktorHttpClient(token: Token) = HttpClient(CIO) {
    defaultRequest {
        headers {
            this["Authorization"] = token.token
        }
        url {
            port = 8080
            host = "192.168.1.5"
            protocol = URLProtocol.HTTP
        }
    }
    install(Logging) {
        level = LogLevel.BODY
        logger = Logger.ANDROID
    }
    install(ContentNegotiation) {
        json(Json {
            ignoreUnknownKeys = true
            prettyPrint = true
            isLenient = true
        })
    }
}
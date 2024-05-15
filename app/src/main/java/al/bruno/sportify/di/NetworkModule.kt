package al.bruno.sportify.di

import al.bruno.sportify.BuildConfig
import al.bruno.sportify.interceptor.Token
import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.api.http.HttpRequest
import com.apollographql.apollo3.api.http.HttpResponse
import com.apollographql.apollo3.network.http.HttpInterceptor
import com.apollographql.apollo3.network.http.HttpInterceptorChain
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
    single<ApolloClient> { apolloClient(get()) }
}

//fun logging(): HttpLoggingInterceptor {
//    val logging = HttpLoggingInterceptor()
//    logging.level = HttpLoggingInterceptor.Level.BODY
//    return logging
//}

fun apolloClient(token: Token) = ApolloClient.Builder()
    .addHttpInterceptor(object : HttpInterceptor {
        override suspend fun intercept(
            request: HttpRequest,
            chain: HttpInterceptorChain
        ): HttpResponse {
            return chain.proceed(
                request.newBuilder().addHeader("Authorization", token.token).build()
            )
        }
    })
    .serverUrl("${BuildConfig.HOST_NAME}/graphql")
    .build()

fun ktorHttpClient(token: Token) = HttpClient(CIO) {
    defaultRequest {
        headers {
            this["Authorization"] = token.token
        }
        url {
            port = BuildConfig.PORT.toInt()
            host = BuildConfig.HOST
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
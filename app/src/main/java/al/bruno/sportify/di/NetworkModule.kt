package al.bruno.sportify.di

import al.bruno.sportify.data.source.remote.service.AuthService
import al.bruno.sportify.data.source.remote.service.EventService
import al.bruno.sportify.data.source.remote.service.LeaveTypesService
import al.bruno.sportify.interceptor.AuthInterceptor
import al.bruno.sportify.interceptor.DateTimeSerializer
import al.bruno.sportify.interceptor.ErrorHandler
import al.bruno.sportify.interceptor.Exclude
import al.bruno.sportify.interceptor.Token
import com.google.gson.ExclusionStrategy
import com.google.gson.FieldAttributes
import com.google.gson.GsonBuilder
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.auth.Auth
import io.ktor.client.plugins.auth.providers.BearerTokens
import io.ktor.client.plugins.auth.providers.bearer
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.gson.gson
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.time.OffsetDateTime

val networkModule = module {
    single<AuthInterceptor> { AuthInterceptor() }
    single<Retrofit> { providerRetrofit(get()) }
    single<ErrorHandler> { errorHandler(get()) }
    single<AuthService> { authService(get()) }
    single<LeaveTypesService> { leaveTypesService(get()) }
    single<EventService> { leaveService(get()) }
    single<Token> { Token("") }
    single<HttpClient> { ktorHttpClient(get()) }
}

fun providerRetrofit(
    authInterceptor: AuthInterceptor
): Retrofit = Retrofit
    .Builder()
    .baseUrl("http://192.168.1.4:8080/")
//    .baseUrl("http://192.168.1.29:8080/")
//    .baseUrl(BuildConfig.HOST_NAME)
    .client(
        OkHttpClient.Builder()
            .addInterceptor(authInterceptor)
//            .addInterceptor(authorizationInterceptor)
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .build()
    )
    .addConverterFactory(ScalarsConverterFactory.create())
    .addConverterFactory(
        GsonConverterFactory.create(
            GsonBuilder()
                .addSerializationExclusionStrategy(object : ExclusionStrategy {
                    override fun shouldSkipClass(clazz: Class<*>?): Boolean {
                        return false
                    }

                    override fun shouldSkipField(f: FieldAttributes?): Boolean {
                        return f?.getAnnotation(Exclude::class.java) != null
                    }

                })
                .registerTypeAdapter(OffsetDateTime::class.java, DateTimeSerializer())
                .setLenient()
                .setPrettyPrinting()
                .create()
        )
    )
    .build()

fun ktorHttpClient(token: Token) = HttpClient(CIO) {
    install(Auth) {
        bearer {
            loadTokens {
                BearerTokens(token.token, "")
            }
        }
    }
    install(ContentNegotiation) {
        gson {
            registerTypeAdapter(OffsetDateTime::class.java, DateTimeSerializer())
        }
    }
}

fun errorHandler(retrofit: Retrofit): ErrorHandler = ErrorHandler(retrofit)
fun authService(retrofit: Retrofit): AuthService = retrofit.create(AuthService::class.java)
fun leaveTypesService(retrofit: Retrofit): LeaveTypesService =
    retrofit.create(LeaveTypesService::class.java)

fun leaveService(retrofit: Retrofit): EventService = retrofit.create(EventService::class.java)
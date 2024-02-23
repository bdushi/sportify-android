package al.bruno.sportify.di

import al.bruno.sportify.data.source.remote.service.AuthService
import al.bruno.sportify.data.source.remote.service.LeaveService
import al.bruno.sportify.data.source.remote.service.LeaveTypesService
import al.bruno.sportify.interceptor.*
import com.google.gson.ExclusionStrategy
import com.google.gson.FieldAttributes
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.Reusable
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.time.LocalDateTime
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
    @Provides
    @Singleton
    fun providerRetrofit(authInterceptor: AuthInterceptor, authorizationInterceptor: AuthorizationInterceptor): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl("http://192.168.1.0:8008/")
//            .baseUrl(BuildConfig.HOST_NAME)
            .client(
                OkHttpClient.Builder()
                    .addInterceptor(authInterceptor)
//                    .addInterceptor(authorizationInterceptor)
                    .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                    .build()
            )
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
                        .registerTypeAdapter(LocalDateTime::class.java,  DateTimeSerializer())
                        .setLenient()
                        .setPrettyPrinting()
                        .create()
                )
            )
            .build()
    }

    @Provides
    @Reusable
    fun errorHandler(retrofit: Retrofit): ErrorHandler {
        return ErrorHandler(retrofit)
    }

    @Provides
    @Reusable
    fun authService(retrofit: Retrofit): AuthService {
        return retrofit.create(AuthService::class.java)
    }

    @Provides
    @Reusable
    fun leaveTypesService(retrofit: Retrofit): LeaveTypesService {
        return retrofit.create(LeaveTypesService::class.java)
    }

    @Provides
    @Reusable
    fun leaveService(retrofit: Retrofit): LeaveService {
        return retrofit.create(LeaveService::class.java)
    }

}
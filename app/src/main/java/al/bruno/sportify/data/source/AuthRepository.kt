package al.bruno.sportify.data.source

import al.bruno.sportify.data.source.local.AuthLocalDataSource
import al.bruno.sportify.data.source.remote.AuthRemoteDataSource
import kotlinx.coroutines.flow.Flow
import okhttp3.ResponseBody
import retrofit2.Response
import javax.inject.Inject

class AuthRepository @Inject constructor(
    private val authRemoteDataSource: AuthRemoteDataSource,
    private val authLocalDataSource: AuthLocalDataSource
) {

    suspend fun auth(username: String, password: String): Response<ResponseBody> {
        return authRemoteDataSource.auth(username = username, password = password)
    }

    suspend fun validateToken(token: String): Response<ResponseBody> {
        return authRemoteDataSource.validateToken(token)
    }

    fun token(): Flow<String?> {
        return authLocalDataSource.token()
    }

    suspend fun token(token: String) {
        return authLocalDataSource.token(token = token)
    }

    suspend fun clear() {
        return authLocalDataSource.clear()
    }
}
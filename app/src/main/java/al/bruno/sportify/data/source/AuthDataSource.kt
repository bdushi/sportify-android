package al.bruno.sportify.data.source

import kotlinx.coroutines.flow.Flow
import okhttp3.ResponseBody
import retrofit2.Response

interface AuthDataSource {
    suspend fun auth(username: String, password: String): Response<ResponseBody>
    suspend fun validateToken(token: String) : Response<ResponseBody>
    fun token(): Flow<String?>
    suspend fun token(token: String)
    suspend fun clear()
}
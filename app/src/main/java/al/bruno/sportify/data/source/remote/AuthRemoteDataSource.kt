package al.bruno.sportify.data.source.remote

import okhttp3.ResponseBody
import retrofit2.Response

interface AuthRemoteDataSource {
    suspend fun auth(username: String, password: String): Response<ResponseBody>
    suspend fun validateToken(token: String): Response<ResponseBody>
}
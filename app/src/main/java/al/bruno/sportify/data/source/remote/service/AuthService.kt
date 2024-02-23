package al.bruno.sportify.data.source.remote.service

import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface AuthService {
    @FormUrlEncoded
    @POST("auth/login")
    suspend fun auth(@Field("username") username: String, @Field("password") password: String) : Response<ResponseBody>
}
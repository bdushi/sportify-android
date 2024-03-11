package al.bruno.sportify.data.source.remote.service

import al.bruno.sportify.model.Page
import al.bruno.sportify.model.dto.LeaveDto
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface EventService {
    @GET("/event")
    suspend fun eventPage(@Query("page") page: Int , @Query("size") size: Int) : Page?

    @POST("/event")
    suspend fun leave(@Body leaveDto: LeaveDto) : Response<ResponseBody>
}
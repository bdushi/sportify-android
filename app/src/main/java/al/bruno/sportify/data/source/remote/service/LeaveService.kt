package al.bruno.sportify.data.source.remote.service

import al.bruno.sportify.model.Page
import al.bruno.sportify.model.dto.LeaveDto
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface LeaveService {
    @GET("/leave")
    suspend fun leave(@Query("search") search: String, @Query("page") page: Int , @Query("size") size: Int) : Response<Page>

    @POST("/leave/request")
    suspend fun leave(@Body leaveDto: LeaveDto) : Response<ResponseBody>
}
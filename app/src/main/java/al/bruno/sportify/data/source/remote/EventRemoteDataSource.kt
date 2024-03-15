package al.bruno.sportify.data.source.remote

import al.bruno.sportify.model.Page
import al.bruno.sportify.model.dto.LeaveDto
import okhttp3.ResponseBody
import retrofit2.Response

interface EventRemoteDataSource {
    suspend fun eventPage(page: Int, size: Int): Page?
    suspend fun events(page: Int, size: Int): Page?
    suspend fun leave(leaveDto: LeaveDto): Response<ResponseBody>
}
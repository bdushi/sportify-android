package al.bruno.sportify.data.source

import al.bruno.sportify.model.Page
import al.bruno.sportify.model.dto.LeaveDto
import okhttp3.ResponseBody
import retrofit2.Response

interface LeaveDataSource {
    suspend fun leave(search: String, page: Int, size: Int) : Response<Page>
    suspend fun leave(leaveDto: LeaveDto) : Response<ResponseBody>
}
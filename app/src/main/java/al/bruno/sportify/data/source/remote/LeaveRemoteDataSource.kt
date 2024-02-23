package al.bruno.sportify.data.source.remote

import al.bruno.sportify.data.source.LeaveDataSource
import al.bruno.sportify.data.source.remote.service.LeaveService
import al.bruno.sportify.model.Page
import al.bruno.sportify.model.dto.LeaveDto
import okhttp3.ResponseBody
import retrofit2.Response
import javax.inject.Inject

class LeaveRemoteDataSource @Inject constructor(private val leaveService: LeaveService) : LeaveDataSource {
    override suspend fun leave(search: String, page: Int, size: Int): Response<Page> {
        return leaveService.leave(search = search, page = page, size = size)
    }

    override suspend fun leave(leaveDto: LeaveDto): Response<ResponseBody> {
        return leaveService.leave(leaveDto = leaveDto)
    }
}
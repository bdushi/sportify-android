package al.bruno.sportify.data.source

import al.bruno.sportify.data.source.remote.LeaveRemoteDataSource
import al.bruno.sportify.model.Page
import al.bruno.sportify.model.dto.LeaveDto
import okhttp3.ResponseBody
import retrofit2.Response
import javax.inject.Inject

class LeaveRepository @Inject constructor(private val leaveDataSource: LeaveRemoteDataSource) {
    suspend fun leave(search: String, page: Int, size: Int) : Response<Page> {
        return leaveDataSource.leave(search = search, page = page, size = size)
    }

    suspend fun leave(leaveDto: LeaveDto) : Response<ResponseBody> {
        return leaveDataSource.leave(leaveDto = leaveDto)
    }
}
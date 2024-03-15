package al.bruno.sportify.data.source.remote

import al.bruno.sportify.model.Page
import al.bruno.sportify.model.dto.LeaveDto

interface EventRemoteDataSource {
    suspend fun events(page: Int, size: Int): Page?
    suspend fun leave(leaveDto: LeaveDto)
}
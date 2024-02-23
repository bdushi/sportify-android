package al.bruno.sportify.data.source.remote

import al.bruno.sportify.data.source.LeaveTypesDataSource
import al.bruno.sportify.data.source.remote.service.LeaveTypesService
import al.bruno.sportify.model.LeaveTypes
import retrofit2.Response
import javax.inject.Inject

class LeaveTypesRemoteDataSource @Inject constructor(private val leaveTypesService: LeaveTypesService) : LeaveTypesDataSource {
    override suspend fun leaveType(): Response<List<LeaveTypes>> {
        return leaveTypesService.leaveTypes()
    }
}
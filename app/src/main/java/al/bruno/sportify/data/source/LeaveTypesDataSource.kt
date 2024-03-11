package al.bruno.sportify.data.source

import al.bruno.sportify.data.source.remote.LeaveTypesRemoteDataSource
import al.bruno.sportify.data.source.remote.service.LeaveTypesService
import al.bruno.sportify.model.EventTypes
import retrofit2.Response

class LeaveTypesDataSource constructor(private val leaveTypesService: LeaveTypesService) :
    LeaveTypesRemoteDataSource {
    override suspend fun leaveType(): Response<List<EventTypes>> {
        return leaveTypesService.leaveTypes()
    }
}
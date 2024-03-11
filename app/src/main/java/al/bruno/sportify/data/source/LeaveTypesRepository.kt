package al.bruno.sportify.data.source

import al.bruno.sportify.model.EventTypes
import retrofit2.Response

class LeaveTypesRepository(private val leaveTypesDataSource: LeaveTypesDataSource) {
    suspend fun leaveTypes(): Response<List<EventTypes>> {
        return leaveTypesDataSource.leaveType()
    }
}
package al.bruno.sportify.data.source

import al.bruno.sportify.model.LeaveTypes
import retrofit2.Response

interface LeaveTypesDataSource {
    suspend fun leaveType() : Response<List<LeaveTypes>>
}
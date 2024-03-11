package al.bruno.sportify.data.source.remote

import al.bruno.sportify.model.EventTypes
import retrofit2.Response

interface LeaveTypesRemoteDataSource {
    suspend fun leaveType() : Response<List<EventTypes>>
}
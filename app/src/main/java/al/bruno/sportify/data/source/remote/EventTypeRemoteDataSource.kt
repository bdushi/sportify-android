package al.bruno.sportify.data.source.remote

import al.bruno.sportify.model.EventType
import retrofit2.Response

interface EventTypeRemoteDataSource {
    suspend fun leaveType() : Response<List<EventType>>
}
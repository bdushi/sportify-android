package al.bruno.sportify.data.source.remote

import al.bruno.sportify.model.EventType

interface EventTypeRemoteDataSource {
    suspend fun leaveType(): List<EventType>
}
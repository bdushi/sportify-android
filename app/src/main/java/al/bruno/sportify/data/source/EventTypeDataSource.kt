package al.bruno.sportify.data.source

import al.bruno.sportify.data.source.remote.EventTypeRemoteDataSource
import al.bruno.sportify.model.EventType
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class EventTypeDataSource(private val httpClient: HttpClient) :
    EventTypeRemoteDataSource {
    override suspend fun leaveType(): List<EventType> {
        return httpClient.get("").body()
    }
}
package al.bruno.sportify.data.source

import al.bruno.sportify.data.source.remote.EventRemoteDataSource
import al.bruno.sportify.data.source.remote.service.EventService
import al.bruno.sportify.model.Page
import al.bruno.sportify.model.dto.LeaveDto
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.url
import okhttp3.ResponseBody
import retrofit2.Response

class EventDataSource(private val eventService: EventService, private val httpClient: HttpClient) :
    EventRemoteDataSource {
    override suspend fun eventPage(page: Int, size: Int): Page? =
        eventService.eventPage(page = page, size = size)

    override suspend fun events(page: Int, size: Int): Page? = httpClient.get {
        url("http://192.168.1.4:8080/event?page=${page}&size=${size}")
    }.body()

    override suspend fun leave(leaveDto: LeaveDto): Response<ResponseBody> {
        return eventService.leave(leaveDto = leaveDto)
    }
}
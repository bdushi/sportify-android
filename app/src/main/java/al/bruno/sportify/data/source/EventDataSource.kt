package al.bruno.sportify.data.source

import al.bruno.sportify.data.source.remote.EventRemoteDataSource
import al.bruno.sportify.model.Page
import al.bruno.sportify.model.dto.LeaveDto
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.url

class EventDataSource(private val httpClient: HttpClient) :
    EventRemoteDataSource {
    override suspend fun events(page: Int, size: Int): Page? = httpClient.get {
        url("event?page=${page}&size=${size}")
    }.body<Page?>()

    override suspend fun leave(leaveDto: LeaveDto) {
        // TODO
    }
}
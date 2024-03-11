package al.bruno.sportify.data.source

import al.bruno.sportify.data.source.remote.EventRemoteDataSource
import al.bruno.sportify.data.source.remote.service.EventService
import al.bruno.sportify.model.Page
import al.bruno.sportify.model.dto.LeaveDto
import okhttp3.ResponseBody
import retrofit2.Response

class EventDataSource(private val eventService: EventService) : EventRemoteDataSource {
    override suspend fun eventPage(page: Int, size: Int): Page? = eventService.eventPage(page = page, size = size)

    override suspend fun leave(leaveDto: LeaveDto): Response<ResponseBody> {
        return eventService.leave(leaveDto = leaveDto)
    }
}
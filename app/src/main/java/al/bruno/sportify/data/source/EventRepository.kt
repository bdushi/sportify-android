package al.bruno.sportify.data.source

import al.bruno.sportify.model.Page
import al.bruno.sportify.model.dto.LeaveDto
import okhttp3.ResponseBody
import retrofit2.Response

class EventRepository(private val eventDataSource: EventDataSource) {
    suspend fun eventPage( page: Int, size: Int) : Page? {
        return eventDataSource.eventPage(page = page, size = size)

    }

    suspend fun leave(leaveDto: LeaveDto) : Response<ResponseBody> {
        return eventDataSource.leave(leaveDto = leaveDto)
    }
}
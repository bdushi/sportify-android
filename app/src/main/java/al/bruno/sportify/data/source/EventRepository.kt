package al.bruno.sportify.data.source

import al.bruno.sportify.model.Page
import al.bruno.sportify.model.dto.LeaveDto

class EventRepository(private val eventDataSource: EventDataSource) {
    suspend fun eventPage( page: Int, size: Int) : Page? {
        return eventDataSource.events(page = page, size = size)

    }

    suspend fun leave(leaveDto: LeaveDto) {
        eventDataSource.leave(leaveDto = leaveDto)
    }
}
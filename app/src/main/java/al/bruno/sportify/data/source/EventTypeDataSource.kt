package al.bruno.sportify.data.source

import al.bruno.sportify.data.source.remote.EventTypeRemoteDataSource
import al.bruno.sportify.data.source.remote.service.LeaveTypesService
import al.bruno.sportify.model.EventType
import retrofit2.Response

class EventTypeDataSource(private val leaveTypesService: LeaveTypesService) :
    EventTypeRemoteDataSource {
    override suspend fun leaveType(): Response<List<EventType>> {
        return leaveTypesService.leaveTypes()
    }
}
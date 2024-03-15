package al.bruno.sportify.data.source

import al.bruno.sportify.model.EventType

class LeaveTypesRepository(private val leaveTypesDataSource: EventTypeDataSource) {
    suspend fun leaveTypes(): List<EventType> {
        return leaveTypesDataSource.leaveType()
    }
}
package al.bruno.sportify.data.source

import al.bruno.sportify.EventQuery
import al.bruno.sportify.model.Page

class EventRepository(private val eventDataSource: EventDataSource) {
    suspend fun eventPage( page: Int, size: Int) : Page? {
        return eventDataSource.events(page = page, size = size)
    }

    suspend fun events(first: Int, after: String?): EventQuery.Data? {
        return eventDataSource.events(first, after)
    }
}
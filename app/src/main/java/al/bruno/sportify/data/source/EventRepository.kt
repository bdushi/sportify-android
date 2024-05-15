package al.bruno.sportify.data.source

import al.bruno.sportify.ui.domain.CursorEvent
import al.bruno.sportify.model.Page

class EventRepository(private val eventDataSource: EventDataSource) {
    suspend fun eventPage( page: Int, size: Int) : Page? {
        return eventDataSource.events(page = page, size = size)
    }

    suspend fun events(first: Int, after: String?): CursorEvent {
        return eventDataSource.events(first, after)
    }
}
package al.bruno.sportify.ui.event.items

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import al.bruno.sportify.data.source.EventRepository
import al.bruno.sportify.ui.domain.Event
import al.bruno.sportify.model.EventType
import al.bruno.sportify.page.CursorLeavePageSource
import kotlinx.coroutines.flow.Flow

class EventViewModel(
    private val eventRepository: EventRepository,
): ViewModel() {

    var leaves: List<Event> by mutableStateOf(listOf())
        private set

    var eventTypes: List<EventType> by mutableStateOf(listOf())
        private set

    val pagedLeaves: Flow<PagingData<Event>> = Pager(
        PagingConfig(
            pageSize = 10,
            enablePlaceholders = true
        )
    ) {
        CursorLeavePageSource(eventRepository = eventRepository)
    }.flow
}
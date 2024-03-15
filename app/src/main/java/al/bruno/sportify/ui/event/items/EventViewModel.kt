package al.bruno.sportify.ui.event.items

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import al.bruno.sportify.data.source.EventRepository
import al.bruno.sportify.data.source.LeaveTypesRepository
import al.bruno.sportify.model.Event
import al.bruno.sportify.model.EventType
import al.bruno.sportify.model.dto.LeaveDto
import al.bruno.sportify.page.LeavePageSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import java.lang.Exception

class EventViewModel(
    private val eventRepository: EventRepository,
    private val leaveTypesRepository: LeaveTypesRepository,
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
        LeavePageSource(eventRepository = eventRepository)
    }.flow

    fun leave() {
        viewModelScope.launch {
            try {
                eventRepository.eventPage( 0, 10)?.let {
                    leaves = it.event
                }
            } catch (ex: Exception) {
                Log.d(EventViewModel::class.java.name, ex.message.toString())
            }
        }
    }
}
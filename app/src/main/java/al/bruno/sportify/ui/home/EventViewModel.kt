package al.bruno.sportify.ui.home

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
import al.bruno.sportify.interceptor.ErrorHandler
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
    private val errorHandler: ErrorHandler
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

    fun leaveTypes() {
        viewModelScope.launch {
            try {
                val response = leaveTypesRepository.leaveTypes()
                if(response.isSuccessful) {
                    response.body()?.let {
                        eventTypes = it
                    }
                } else {
                    Log.d(EventViewModel::class.java.name, errorHandler.parseError(response).message.toString())
                }
            } catch (ex: Exception) {
                Log.d(EventViewModel::class.java.name, ex.message.toString())
            }
        }
    }

    fun leave(leaveDto: LeaveDto) {
        viewModelScope.launch {
            try {
                val response = eventRepository.leave(leaveDto)
                if(response.isSuccessful) {
                    Log.d(EventViewModel::class.java.name, errorHandler.parseError(response).message.toString())
                } else {
                    Log.d(EventViewModel::class.java.name, errorHandler.parseError(response).message.toString())
                }
            } catch (ex: Exception) {
                Log.d(EventViewModel::class.java.name, ex.message.toString())
            }
        }
    }
}
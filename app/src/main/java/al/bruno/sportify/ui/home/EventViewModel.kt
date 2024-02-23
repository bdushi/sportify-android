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
import al.bruno.sportify.data.source.LeaveRepository
import al.bruno.sportify.data.source.LeaveTypesRepository
import al.bruno.sportify.interceptor.ErrorHandler
import al.bruno.sportify.model.Leave
import al.bruno.sportify.model.LeaveTypes
import al.bruno.sportify.model.dto.LeaveDto
import al.bruno.sportify.page.LeavePageSource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class EventViewModel @Inject constructor(
        private val leaveRepository: LeaveRepository,
        private val leaveTypesRepository: LeaveTypesRepository,
        private val errorHandler: ErrorHandler
): ViewModel() {

    var leaves: List<Leave> by mutableStateOf(listOf())
        private set

    var leaveTypes: List<LeaveTypes> by mutableStateOf(listOf())
        private set


    var startDate:String by mutableStateOf("")

    val pagedLeaves: Flow<PagingData<Leave>> = Pager(
        PagingConfig(
            pageSize = 10,
            enablePlaceholders = true
        )
    ) {
        LeavePageSource(leaveRepository = leaveRepository)
    }.flow

    fun leave() {
        viewModelScope.launch {
            try {
                val response = leaveRepository.leave("", 0, 10)
                if(response.isSuccessful) {
                    response.body()?.let {
                        leaves = it.leave
                    }
                } else {
                    Log.d(EventViewModel::class.java.name, errorHandler.parseError(response).message.toString())
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
                        leaveTypes = it
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
                val response = leaveRepository.leave(leaveDto)
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
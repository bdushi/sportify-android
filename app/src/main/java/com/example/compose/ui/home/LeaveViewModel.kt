package com.example.compose.ui.home

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.compose.data.source.LeaveRepository
import com.example.compose.interceptor.ErrorHandler
import com.example.compose.model.Leave
import kotlinx.coroutines.launch
import java.lang.Exception

class LeaveViewModel @ViewModelInject constructor(
    private val leaveRepository: LeaveRepository,
    private val errorHandler: ErrorHandler
): ViewModel() {

//    var leaves: List<Leave> by mutableStateOf(listOf())
//        private set

    fun leave() {
        viewModelScope.launch {
            try {
                val response = leaveRepository.leave()
                if(response.isSuccessful) {
//                    response.body()?.let {
//                        leaves = it
//                    }
                    Log.d(LeaveViewModel::class.java.name, response.body().toString())
                } else {
                    Log.d(LeaveViewModel::class.java.name, errorHandler.parseError(response).message.toString())
                }
            } catch (ex: Exception) {
                Log.d(LeaveViewModel::class.java.name, ex.message.toString())
            }
        }
    }
}
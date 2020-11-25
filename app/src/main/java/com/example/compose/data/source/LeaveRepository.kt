package com.example.compose.data.source

import com.example.compose.model.Leave
import retrofit2.Response
import javax.inject.Inject

class LeaveRepository @Inject constructor(private val leaveRemoteDataSource: LeaveDataSource) {
    suspend fun leave() : Response<List<Leave>> {
        return leaveRemoteDataSource.leave()
    }
}
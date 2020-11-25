package com.example.compose.data.source.remote

import com.example.compose.data.source.LeaveDataSource
import com.example.compose.data.source.remote.service.LeaveService
import com.example.compose.model.Leave
import retrofit2.Response
import javax.inject.Inject

class LeaveRemoteDataSource @Inject constructor(private val leaveService: LeaveService) : LeaveDataSource{
    override suspend fun leave(): Response<List<Leave>> {
        return leaveService.leave()
    }
}
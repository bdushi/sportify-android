package com.example.compose.data.source.remote.service

import com.example.compose.model.Leave
import retrofit2.Response
import retrofit2.http.GET

interface LeaveService {
    @GET("/leave/request")
    suspend fun leave() : Response<List<Leave>>
}
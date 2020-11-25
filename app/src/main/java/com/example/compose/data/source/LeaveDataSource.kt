package com.example.compose.data.source

import com.example.compose.model.Leave
import retrofit2.Response

interface LeaveDataSource {
    suspend fun leave() : Response<List<Leave>>
}
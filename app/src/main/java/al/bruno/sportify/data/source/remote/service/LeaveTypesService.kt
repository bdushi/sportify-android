package al.bruno.sportify.data.source.remote.service

import al.bruno.sportify.model.LeaveTypes
import retrofit2.Response
import retrofit2.http.GET

interface LeaveTypesService {
    @GET("/leaveTypes")
    suspend fun leaveTypes() : Response<List<LeaveTypes>>
}
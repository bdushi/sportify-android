package al.bruno.sportify.data.source

import al.bruno.sportify.data.source.remote.LeaveTypesRemoteDataSource
import al.bruno.sportify.model.LeaveTypes
import retrofit2.Response
import javax.inject.Inject

class LeaveTypesRepository @Inject constructor(private val leaveTypesDataSource: LeaveTypesRemoteDataSource){
    suspend fun leaveTypes() : Response<List<LeaveTypes>> {
        return leaveTypesDataSource.leaveType()
    }
}
package al.bruno.sportify.data.source.remote

import al.bruno.sportify.GetAllReferencesQuery
interface NewEventRemoteDataSource {
    suspend fun getAllReferences() : GetAllReferencesQuery.Data?
}
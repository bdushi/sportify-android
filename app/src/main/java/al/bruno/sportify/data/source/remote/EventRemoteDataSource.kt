package al.bruno.sportify.data.source.remote

import al.bruno.sportify.EventQuery
import al.bruno.sportify.model.Page

interface EventRemoteDataSource {
    suspend fun events(page: Int, size: Int): Page?
    suspend fun events(first: Int, after: String?): EventQuery.Data?
}
package al.bruno.sportify.data.source

import al.bruno.sportify.EventQuery
import al.bruno.sportify.data.source.remote.EventRemoteDataSource
import al.bruno.sportify.model.Page
import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.api.Optional
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.url

class EventDataSource(
    private val httpClient: HttpClient,
    private val apolloClient: ApolloClient
) : EventRemoteDataSource {
    override suspend fun events(page: Int, size: Int): Page? = httpClient.get {
        url("event?page=${page}&size=${size}")
    }.body<Page?>()

    override suspend fun events(first: Int, after: String?): EventQuery.Data? {
        return apolloClient
            .query(EventQuery(first, Optional.presentIfNotNull(after)))
            .execute()
            .data
    }
}
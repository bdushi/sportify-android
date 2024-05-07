package al.bruno.sportify.data.source

import al.bruno.sportify.GetAllReferencesQuery
import al.bruno.sportify.data.source.remote.NewEventRemoteDataSource
import com.apollographql.apollo3.ApolloClient

class NewEventDataSource(
    private val apolloClient: ApolloClient
) : NewEventRemoteDataSource {
    override suspend fun getAllReferences(): GetAllReferencesQuery.Data? {
        return apolloClient.query(GetAllReferencesQuery())
            .execute()
            .data
    }
}
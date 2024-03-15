package al.bruno.sportify.data.source.local

import io.ktor.client.plugins.auth.providers.BearerTokens
import kotlinx.coroutines.flow.Flow

interface AuthLocalDataSource {
    fun token(): Flow<String?>
    suspend fun token(token: String)
    suspend fun clear()
}
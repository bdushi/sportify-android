package al.bruno.sportify.data.source

import al.bruno.sportify.common.TOKEN
import al.bruno.sportify.data.source.local.AuthLocalDataSource
import al.bruno.sportify.data.source.remote.AuthRemoteDataSource
import al.bruno.sportify.data.source.remote.service.AuthService
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import io.ktor.client.plugins.auth.providers.BearerTokens
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import okhttp3.ResponseBody
import retrofit2.Response

class AuthDataSource(
    private val dataStore: DataStore<Preferences>,
    private val authService: AuthService
) : AuthRemoteDataSource, AuthLocalDataSource {

    override suspend fun auth(username: String, password: String): Response<ResponseBody> {
        return authService.auth(username, password)
    }

    override suspend fun validateToken(token: String) = authService.validateToken(token)

    override fun token(): Flow<String?> {
        return dataStore.data.map { it[stringPreferencesKey(TOKEN)] }
    }

    override suspend fun token(token: String) {
        dataStore.edit {
            it[stringPreferencesKey(TOKEN)] = token
        }
    }

    override suspend fun clear() {
        dataStore.edit {
            it.clear()
        }
    }
}
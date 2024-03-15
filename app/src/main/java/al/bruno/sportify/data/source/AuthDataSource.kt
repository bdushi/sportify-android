package al.bruno.sportify.data.source

import al.bruno.sportify.common.TOKEN
import al.bruno.sportify.data.source.local.AuthLocalDataSource
import al.bruno.sportify.data.source.remote.AuthRemoteDataSource
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.forms.FormDataContent
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.Parameters
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class AuthDataSource(
    private val dataStore: DataStore<Preferences>, private val httpClient: HttpClient
) : AuthRemoteDataSource, AuthLocalDataSource {
    override suspend fun auth(username: String, password: String) = httpClient.post {
        setBody(
            FormDataContent(Parameters.build {
                append("username", username)
                append("password", password)
            })
        )
    }.body<String?>()


    override suspend fun validateToken(token: String) =
        httpClient.get("http://192.168.1.5:8080/token/validate/${token}").body<String?>()

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
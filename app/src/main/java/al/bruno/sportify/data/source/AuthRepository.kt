package al.bruno.sportify.data.source

import kotlinx.coroutines.flow.Flow

class AuthRepository(
    private val authDataSource: AuthDataSource
) {

    suspend fun auth(username: String, password: String): String? {
        return authDataSource.auth(username = username, password = password)
    }

    suspend fun validateToken(token: String) = authDataSource.validateToken(token)

    fun token(): Flow<String?> {
        return authDataSource.token()
    }

    suspend fun token(token: String) {
        return authDataSource.token(token = token)
    }

    suspend fun clear() {
        return authDataSource.clear()
    }
}
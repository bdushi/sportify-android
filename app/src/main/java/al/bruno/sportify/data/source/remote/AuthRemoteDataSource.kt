package al.bruno.sportify.data.source.remote

interface AuthRemoteDataSource {
    suspend fun auth(username: String, password: String): String?
    suspend fun validateToken(token: String): String?
}
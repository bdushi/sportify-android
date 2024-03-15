package al.bruno.sportify.model

import al.bruno.sportify.interceptor.OffsetDateTimeSerializer
import kotlinx.serialization.Serializable
import java.time.OffsetDateTime

@Serializable
data class User(
    val id: String,
    val username: String,
    val email: String,
    val firstName: String,
    val lastName: String,
    val address: String,
    val phone: String,
    val authorities: List<Authority>,
    val enabled: Boolean,
    val accountNonExpired: Boolean,
    val accountNonLocked: Boolean,
    val credentialsNonExpired: Boolean,
    @Serializable(OffsetDateTimeSerializer::class)
    var dateCreated: OffsetDateTime,
    @Serializable(OffsetDateTimeSerializer::class)
    var lastUpdated: OffsetDateTime
)

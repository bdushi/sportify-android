package al.bruno.sportify.model

import java.time.OffsetDateTime
import java.util.UUID

data class User(
    val id: UUID,
    val username: String,
    val email: String,
    val firstName: String,
    val lastName: String,
    val address: String,
    val phone: String,
    val authorities: MutableCollection<Authority>,
    val enabled: Boolean,
    val accountNonExpired: Boolean,
    val accountNonLocked: Boolean,
    val credentialsNonExpired: Boolean,
    var dateCreated: OffsetDateTime,
    var lastUpdated: OffsetDateTime
)

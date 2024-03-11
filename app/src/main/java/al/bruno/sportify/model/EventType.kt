package al.bruno.sportify.model

import java.time.OffsetDateTime

data class EventType(
    val id: String,
    val code: String,
    val name: String,
    val description: String,
    val enabled: Boolean,
    var dateCreated: OffsetDateTime,
    var lastUpdated: OffsetDateTime
)
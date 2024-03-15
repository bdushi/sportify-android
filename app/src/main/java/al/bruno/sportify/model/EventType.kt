package al.bruno.sportify.model

import al.bruno.sportify.interceptor.OffsetDateTimeSerializer
import kotlinx.serialization.Serializable
import java.time.OffsetDateTime

@Serializable
data class EventType(
    val id: String,
    val code: String,
    val name: String,
    val description: String,
    val enabled: Boolean,
    @Serializable(OffsetDateTimeSerializer::class)
    var dateCreated: OffsetDateTime,
    @Serializable(OffsetDateTimeSerializer::class)
    var lastUpdated: OffsetDateTime
)
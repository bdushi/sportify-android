package al.bruno.sportify.model

import al.bruno.sportify.interceptor.OffsetDateTimeSerializer
import kotlinx.serialization.Serializable
import java.time.OffsetDateTime

@Serializable
data class Event(
    val id: String,
    val title: String,
    val description: String,
    val price: Double,
    val latitude: Double,
    val longitude: Double,
    val address: String,
    val street: String,
    val province: String,
    val enabled: Boolean,
    val created: User,
    val eventType: EventType,
    val currency: Currency,
    @Serializable(OffsetDateTimeSerializer::class)
    val dateCreated: OffsetDateTime,
    @Serializable(OffsetDateTimeSerializer::class)
    val lastUpdated: OffsetDateTime,
    @Serializable(OffsetDateTimeSerializer::class)
    val startDate: OffsetDateTime,
    @Serializable(OffsetDateTimeSerializer::class)
    val endDate: OffsetDateTime,
)
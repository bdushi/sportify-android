package al.bruno.sportify.model

import java.time.OffsetDateTime

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
    val dateCreated: OffsetDateTime,
    val lastUpdated: OffsetDateTime,
    val startDate: OffsetDateTime,
    val endDate: OffsetDateTime,
)
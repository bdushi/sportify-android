package al.bruno.sportify.model

import java.time.LocalDateTime
import java.util.UUID

data class Event(
    val id: UUID,
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
    val eventTypes: EventTypes,
    val approved: Currency,
    val createDate: LocalDateTime,
    val startDate:LocalDateTime,
    val endDate: LocalDateTime,
    )
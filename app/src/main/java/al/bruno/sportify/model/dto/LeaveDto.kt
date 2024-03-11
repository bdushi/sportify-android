package al.bruno.sportify.model.dto

import al.bruno.sportify.model.EventType
import java.time.OffsetDateTime

data class LeaveDto(
    val description: String,
    val comment: String,
    val eventType: EventType,
    val startDate: OffsetDateTime,
    val endDate: OffsetDateTime
)
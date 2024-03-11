package al.bruno.sportify.model.dto

import al.bruno.sportify.model.EventTypes
import java.time.LocalDateTime

data class LeaveDto(
    val description: String,
    val comment: String,
    val eventTypes: EventTypes,
    val startDate: LocalDateTime,
    val endDate: LocalDateTime
)
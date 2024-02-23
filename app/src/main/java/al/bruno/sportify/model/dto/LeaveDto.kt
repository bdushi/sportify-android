package al.bruno.sportify.model.dto

import al.bruno.sportify.model.LeaveTypes
import java.time.LocalDateTime

data class LeaveDto(
        val description: String,
        val comment: String,
        val leaveTypes: LeaveTypes,
        val startDate: LocalDateTime,
        val endDate: LocalDateTime
)
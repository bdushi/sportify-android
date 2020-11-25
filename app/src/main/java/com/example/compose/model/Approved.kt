package com.example.compose.model

import java.time.LocalDateTime

class Approved(
    val approvedDate: LocalDateTime,
    val comment: String,
    val approved: Boolean,
    val approvedBy: User
)
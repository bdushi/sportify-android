package al.bruno.sportify.model

import java.time.LocalDateTime
import java.time.OffsetDateTime
import java.util.UUID

class Currency(
    val id: UUID,
    val currency: String,
    val symbol: String,
    val code: String,
    val decimalMark: String,
    val enabled: Boolean,
    var dateCreated: OffsetDateTime,
    var lastUpdated: OffsetDateTime,
)
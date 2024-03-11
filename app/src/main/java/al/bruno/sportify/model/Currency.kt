package al.bruno.sportify.model

import java.time.OffsetDateTime

class Currency(
    val id: String,
    val currency: String,
    val symbol: String,
    val code: String,
    val decimalMark: String,
    val enabled: Boolean,
    var dateCreated: OffsetDateTime,
    var lastUpdated: OffsetDateTime,
)
package al.bruno.sportify.model

import al.bruno.sportify.interceptor.OffsetDateTimeSerializer
import kotlinx.serialization.Serializable
import java.time.OffsetDateTime

@Serializable
class Currency(
    val id: String,
    val currency: String,
    val symbol: String,
    val code: String,
    val decimalMark: String,
    val enabled: Boolean,
    @Serializable(OffsetDateTimeSerializer::class)
    var dateCreated: OffsetDateTime,
    @Serializable(OffsetDateTimeSerializer::class)
    var lastUpdated: OffsetDateTime,
)
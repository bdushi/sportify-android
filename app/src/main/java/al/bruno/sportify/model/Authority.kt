package al.bruno.sportify.model

import al.bruno.sportify.interceptor.OffsetDateTimeSerializer
import kotlinx.serialization.Serializable
import java.time.OffsetDateTime

@Serializable
data class Authority(
    val id: String,
    val authority: String,
    val description: String? = null ,
    val enabled: Boolean = true,
    @Serializable(OffsetDateTimeSerializer::class)
    var dateCreated: OffsetDateTime,
    @Serializable(OffsetDateTimeSerializer::class)
    var lastUpdated: OffsetDateTime,
)
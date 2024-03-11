package al.bruno.sportify.model

import java.time.OffsetDateTime

data class Authority(
    val id: String,
    val authority: String,
    val description: String,
    val enabled: Boolean = true,
    var dateCreated: OffsetDateTime,
    var lastUpdated: OffsetDateTime,
)
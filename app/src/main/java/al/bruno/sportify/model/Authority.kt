package al.bruno.sportify.model

import java.time.OffsetDateTime
import java.util.UUID

data class Authority(
    val id: UUID,
    private val authority: String,
    private val description: String,
    val enabled: Boolean = true,
    var dateCreated: OffsetDateTime,
    var lastUpdated: OffsetDateTime,
)
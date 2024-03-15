package al.bruno.sportify.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Page(
    @SerialName("content")
    val event: List<Event>,
    val pageable: Pageable,
    val totalPages: Int,
    val totalElements: Int,
    val sort: Sort,
    val last: Boolean,
    val size: Int,
    val numberOfElements: Int,
    val first: Boolean,
    val number: Int,
    val empty: Boolean
)
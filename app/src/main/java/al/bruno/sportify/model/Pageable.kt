package al.bruno.sportify.model

import kotlinx.serialization.Serializable

@Serializable
data class Pageable(
    val sort: Sort,
    val pageNumber: Int,
    val pageSize: Int,
    val offset: Int,
    val paged: Boolean,
    val unPaged: Boolean,
)
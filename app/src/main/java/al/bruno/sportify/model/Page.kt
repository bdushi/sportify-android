package al.bruno.sportify.model

import com.google.gson.annotations.SerializedName

data class Page(
    @SerializedName("content")
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
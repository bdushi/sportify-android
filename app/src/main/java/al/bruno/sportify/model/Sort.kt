package al.bruno.sportify.model

import kotlinx.serialization.Serializable

@Serializable
data class Sort(
    val sorted: Boolean,
    val unsorted: Boolean,
    val empty: Boolean
)
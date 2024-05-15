package al.bruno.sportify.ui.domain

data class CursorEvent(
    val event: List<Event>?,
    val nextPage: String?
)

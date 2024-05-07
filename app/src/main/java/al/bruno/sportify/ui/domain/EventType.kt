package al.bruno.sportify.ui.domain

data class EventType(
    val id: String,
    val code: String,
    val name: String,
    val description: String,
    val enabled: Boolean,
    val dateCreated: String,
    val lastUpdated: String
)
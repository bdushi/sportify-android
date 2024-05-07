package al.bruno.sportify.ui.domain

data class Difficulty(
    val id: String,
    val code: String,
    val level: String,
    val description: String,
    val enabled: Boolean,
    val dateCreated: String,
    val lastUpdated: String
)
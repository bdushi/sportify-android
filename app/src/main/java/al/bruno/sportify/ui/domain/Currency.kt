package al.bruno.sportify.ui.domain

data class Currency(
    val id: String,
    val currency: String,
    val symbol: String,
    val code: String,
    val decimalMark: String,
    val enabled: Boolean,
    val dateCreated: String,
    val lastUpdated: String
)

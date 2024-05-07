package al.bruno.sportify.ui.domain

data class City(
    val id: String,
    val city: String,
    val zipCode: String,
    val country: Country,
    val enabled: Boolean,
    val dateCreated: String,
    val lastUpdated: String?
)
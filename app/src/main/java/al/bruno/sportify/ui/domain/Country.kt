package al.bruno.sportify.ui.domain

data class Country(
    val id: String,
    val country: String,
    val countryCode: String,
//    val cities: List<City>,
    val enabled: Boolean,
    val dateCreated: String,
    val lastUpdated: String
)
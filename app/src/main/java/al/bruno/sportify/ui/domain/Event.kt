package al.bruno.sportify.ui.domain

data class Event (
    val id: String,
    val title: String,
    val description: String,
    val dateCreated: String,
    val lastUpdated: String,
    val startedDate: String,
    val endedDate: String,
    val price: Double,
    val latitude: Double,
    val longitude: Double,
    val address: String,
    val street: String,
    val province: String,
    val enabled: Boolean,
    val username: String,
    val email: String,
    val firstName: String,
    val lastName: String,
    val city: String,
    val zipCode: String,
    val country: String,
    val countryCode: String,
    val currency: String,
    val symbol: String,
    val currencyCode: String,
    val decimalMark: String,
    val difficultyCode: String,
    val difficultyDescription: String,
    val eventTypeCode: String,
    val eventTypeName: String,
    val eventTypeDescription: String,
    val participantsIds: List<String>?,
)
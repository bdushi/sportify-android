package al.bruno.sportify.ui.domain

data class Reference(
    val city: List<City?>,
    val currency: List<Currency?>,
    val difficulty: List<Difficulty?>,
    val eventType: List<EventType?>
)
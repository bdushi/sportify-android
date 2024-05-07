package al.bruno.sportify.data.source

import al.bruno.sportify.GetAllReferencesQuery
import al.bruno.sportify.ui.domain.City
import al.bruno.sportify.ui.domain.Country
import al.bruno.sportify.ui.domain.Currency
import al.bruno.sportify.ui.domain.Difficulty
import al.bruno.sportify.ui.domain.EventType
import al.bruno.sportify.ui.domain.Reference

class NewEventRepository constructor(private val newEventDataSource: NewEventDataSource) {
    suspend fun getAllReference(): Reference? {
        return newEventDataSource
            .getAllReferences()?.toReference()
    }
}

fun GetAllReferencesQuery.Data.toReference() = Reference(
    this.cities.map { it?.toCity() },
    this.currencies.map { it?.toCurrency() },
    this.difficulties.map { it?.toDifficulty() },
    this.eventTypes.map { it?.toEventType() }
)

fun GetAllReferencesQuery.City.toCity(): City = City(
    this.id,
    this.city,
    this.zipCode,
    Country(
        this.country.id,
        this.country.country,
        this.country.countryCode,
        this.enabled,
        this.dateCreated,
        this.lastUpdated
    ),
    this.enabled,
    this.dateCreated,
    this.lastUpdated
)

fun GetAllReferencesQuery.Currency.toCurrency(): Currency = Currency(
    this.id,
    this.currency,
    this.symbol,
    this.code,
    this.decimalMark,
    this.enabled,
    this.dateCreated,
    this.lastUpdated
)

fun GetAllReferencesQuery.Difficulty.toDifficulty(): Difficulty = Difficulty(
    this.id,
    this.code,
    this.level,
    this.description,
    this.enabled,
    this.dateCreated,
    this.lastUpdated
)

fun GetAllReferencesQuery.EventType.toEventType(): EventType = EventType(
    this.id,
    this.code,
    this.name,
    this.description,
    this.enabled,
    this.dateCreated,
    this.lastUpdated
)

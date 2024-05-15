package al.bruno.sportify.data.source.mapper

import al.bruno.sportify.EventQuery
import al.bruno.sportify.ui.domain.CursorEvent
import al.bruno.sportify.ui.domain.Event

fun EventQuery.Node.mapToEvent() = Event(
    id,
    title,
    description,
    dateCreated,
    lastUpdated,
    startedDate,
    endedDate,
    price,
    latitude,
    longitude,
    address,
    street,
    province,
    enabled,
    username,
    email,
    firstName,
    lastName,
    city,
    zipCode,
    country,
    countryCode,
    currency,
    symbol,
    currencyCode,
    decimalMark,
    difficultyCode,
    difficultyDescription,
    eventTypeCode,
    eventTypeName,
    eventTypeDescription,
    participantsIds
)

fun EventQuery.Events.mapToEvents() =
    edges
        .mapNotNull { it?.node }
        .map {
            it.mapToEvent()
        }

fun EventQuery.Data?.mapToCursorEvent() = CursorEvent(
    event = this?.events?.mapToEvents(),
    nextPage = this?.events?.pageInfo?.endCursor
)
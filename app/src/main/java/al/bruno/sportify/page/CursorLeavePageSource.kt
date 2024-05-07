package al.bruno.sportify.page

import al.bruno.sportify.ui.domain.Event
import al.bruno.sportify.data.source.EventRepository
import androidx.paging.PagingSource
import androidx.paging.PagingState

class CursorLeavePageSource(
    private val eventRepository: EventRepository
) : PagingSource<String, Event>() {
    override suspend fun load(params: LoadParams<String>): LoadResult<String, Event> {
        try {
            val response = eventRepository.events(first = params.loadSize, after = params.key)
            val items = response?.events?.edges?.mapNotNull { it?.node }?.map {
                Event(
                    it.id,
                    it.title,
                    it.description,
                    it.dateCreated,
                    it.lastUpdated,
                    it.startedDate,
                    it.endedDate,
                    it.price,
                    it.latitude,
                    it.longitude,
                    it.address,
                    it.street,
                    it.province,
                    it.enabled,
                    it.username,
                    it.email,
                    it.firstName,
                    it.lastName,
                    it.city,
                    it.zipCode,
                    it.country,
                    it.countryCode,
                    it.currency,
                    it.symbol,
                    it.currencyCode,
                    it.decimalMark,
                    it.difficultyCode,
                    it.difficultyDescription,
                    it.eventTypeCode,
                    it.eventTypeName,
                    it.eventTypeDescription,
                    it.participantsIds
                )
            }
            val nextPage = response?.events?.pageInfo?.endCursor
            return if (items != null) {
                 LoadResult.Page(
                    data = items,
                    prevKey = null,
                    nextKey = nextPage
                )
            } else {
                LoadResult.Error(Exception("No Data"))
            }
        } catch (e: Exception) {
            return LoadResult.Error(e)
        }
    }

    override val keyReuseSupported: Boolean
        get() = true

    override fun getRefreshKey(state: PagingState<String, Event>): String? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey
                ?: state.closestPageToPosition(anchorPosition)?.nextKey
        }
    }
}


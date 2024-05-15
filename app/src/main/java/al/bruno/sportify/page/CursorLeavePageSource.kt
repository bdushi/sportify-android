package al.bruno.sportify.page

import al.bruno.sportify.data.source.EventRepository
import al.bruno.sportify.ui.domain.Event
import androidx.paging.PagingSource
import androidx.paging.PagingState

class CursorLeavePageSource(
    private val eventRepository: EventRepository
) : PagingSource<String, Event>() {
    override suspend fun load(params: LoadParams<String>): LoadResult<String, Event> {
        try {
            val response = eventRepository.events(first = params.loadSize, after = params.key)
            return if (response?.event.isNullOrEmpty()) {
                 LoadResult.Page(
                    data = response?.event.orEmpty(),
                    prevKey = null,
                    nextKey = response?.nextPage
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


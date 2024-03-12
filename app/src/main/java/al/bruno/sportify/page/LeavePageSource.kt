package al.bruno.sportify.page

import al.bruno.sportify.common.NETWORK_PAGE_SIZE
import al.bruno.sportify.data.source.EventRepository
import al.bruno.sportify.model.Event
import androidx.paging.PagingSource
import androidx.paging.PagingState

class LeavePageSource(
    private val eventRepository: EventRepository
) : PagingSource<Int, Event>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Event> {
        return try {
            val position = params.key ?: 0
            val response = eventRepository.eventPage(position, params.loadSize)
            if (response != null) {
                LoadResult.Page(
                    data = response.event,
                    prevKey = if (position == 0) null else position - 1,
                    nextKey = if (response.empty) null else position + (params.loadSize / NETWORK_PAGE_SIZE)
                )
            } else {
                LoadResult.Error(Exception("No Data"))
            }
        } catch (ex: Exception) {
            LoadResult.Error(ex)
        }
    }

    override val keyReuseSupported: Boolean
        get() = true

    override fun getRefreshKey(state: PagingState<Int, Event>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }
}
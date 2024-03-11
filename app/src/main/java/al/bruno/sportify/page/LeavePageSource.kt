package al.bruno.sportify.page

import androidx.paging.PagingSource
import androidx.paging.PagingState
import al.bruno.sportify.data.source.EventRepository
import al.bruno.sportify.data.source.entity.Result
import al.bruno.sportify.data.source.entity.asResult
import al.bruno.sportify.model.Event
import androidx.compose.runtime.collectAsState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.toCollection

class LeavePageSource(
        private val eventRepository: EventRepository
        ) : PagingSource<Int, Event>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Event> {
        return try {
            val nextPage = params.key ?: 0
            val response = eventRepository.eventPage(nextPage, params.loadSize)
            if(response != null) {
                LoadResult.Page(
                    data = response.event,
                    prevKey = if (nextPage == 0) nextPage else nextPage - 1,
                    nextKey = if (nextPage >= response.numberOfElements) nextPage else response.number + 1
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

    override fun getRefreshKey(state: PagingState<Int, Event>): Int {
        return 0
    }
}
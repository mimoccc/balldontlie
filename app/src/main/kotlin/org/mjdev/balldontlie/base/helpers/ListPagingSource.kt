package org.mjdev.balldontlie.base.helpers

import androidx.paging.PagingSource
import androidx.paging.PagingState
import kotlinx.coroutines.delay
import org.mjdev.balldontlie.base.helpers.Ext.retrySuspend

typealias SOURCE<T> = suspend (page: Int, cnt: Int) -> List<T>

class ListPagingSource<T : Any>(
    private val source: SOURCE<T> = { _, _ -> emptyList() },
    private val maxRetryCount: Int = DEFAULT_MAX_RETRY_COUNT,
    private val retryDelay: Long = DEFAULT_RETRY_DELAY,
) : PagingSource<Int, T>() {

    companion object {
        const val DEFAULT_MAX_RETRY_COUNT = 10
        const val DEFAULT_RETRY_DELAY = 250L // 250 ms
    }

    override fun getRefreshKey(state: PagingState<Int, T>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, T> {
        return try {
            val page = params.key ?: 1
            val response: List<T> = retrySuspend(
                retryDelay = retryDelay,
                maxRetryCount = maxRetryCount,
                condition = { size >= params.loadSize },
                block = { source.invoke(page, params.loadSize) }
            )
            return LoadResult.Page(
                data = response,
                prevKey = if (page == 1) null else page.minus(1),
                nextKey = if (response.isEmpty()) null else page.plus(1),
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

}
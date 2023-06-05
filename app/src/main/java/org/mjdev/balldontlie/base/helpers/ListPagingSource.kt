package org.mjdev.balldontlie.base.helpers

import androidx.paging.PagingSource
import androidx.paging.PagingState
import kotlinx.coroutines.delay

typealias SOURCE<T> = suspend (page: Int, cnt: Int) -> List<T>

class ListPagingSource<T : Any>(
    private val perPage: Int = 50,
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
            var maxTryCount = maxRetryCount
            var response = source.invoke(page, params.loadSize)
            while ((response.isEmpty() || response.size < params.loadSize) && (maxTryCount > 0)) {
                delay(retryDelay)
                maxTryCount -= 1
                response = source.invoke(page, params.loadSize)
            }
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
package org.mjdev.moneta.base.helpers

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingSource
import androidx.paging.PagingState

@Suppress("UNUSED_ANONYMOUS_PARAMETER", "MemberVisibilityCanBePrivate")
class ListPagingSource<T : Any>(

    private val cnt: Long = 8,
    private val source: suspend (page: Long, cnt: Long) -> Result<List<T>> = { p, c ->
        Result.success(emptyList())
    },
) : PagingSource<Long, T>() {

    override fun getRefreshKey(state: PagingState<Long, T>): Long? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Long>): LoadResult<Long, T> {
        return try {
            val page = params.key ?: 1
            val response = source.invoke(page, cnt).getOrThrow()
            LoadResult.Page(
                data = response,
                prevKey = if (page == 1L) null else page.minus(1),
                nextKey = if (response.isEmpty()) null else page.plus(1),
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    companion object {

        fun <T : Any> listPageSource(
            cnt: Long = 8,
            source: suspend (page: Long, cnt: Long) -> Result<List<T>>
        ) = ListPagingSource(cnt, source)

        fun <T : Any> pagerResult(
            cnt: Long = 8,
            source: suspend (page: Long, cnt: Long) -> Result<List<T>>
        ) = Pager(
            config = PagingConfig(pageSize = cnt.toInt()),
            pagingSourceFactory = {
                listPageSource(cnt) { p, c ->
                    source.invoke(p, c)
                }
            }).flow

        fun <T : Any> pagerList(
            cnt: Long = 8,
            source: suspend (page: Long, cnt: Long) -> List<T>
        ) = pagerResult(cnt) { p, c ->
            try {
                Result.success(source(p, c))
            } catch (e: Exception) {
                Result.failure(e)
            }
        }

    }

}
package org.mjdev.balldontlie.base.helpers

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingSource
import androidx.paging.PagingState

@Suppress("UNUSED_ANONYMOUS_PARAMETER", "MemberVisibilityCanBePrivate")
class ListPagingSource<T : Any>(
    private val cnt: Int = 8,
    private val source: suspend (page: Int, cnt: Int) -> Result<List<T>> = { p, c ->
        Result.success(emptyList())
    },
) : PagingSource<Int, T>() {

    override fun getRefreshKey(state: PagingState<Int, T>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, T> {
        return try {
            val page = params.key ?: 1
            val response = source.invoke(page, cnt).getOrThrow()
            LoadResult.Page(
                data = response,
                prevKey = if (page == 1) null else page.minus(1),
                nextKey = if (response.isEmpty()) null else page.plus(1),
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    companion object {

        fun <T : Any> listPageSource(
            cnt: Int = 8,
            source: suspend (page: Int, cnt: Int) -> Result<List<T>>
        ) = ListPagingSource(cnt, source)

        fun <T : Any> pagerResult(
            cnt: Int = 8,
            source: suspend (page: Int, cnt: Int) -> Result<List<T>>
        ) = Pager(
            config = PagingConfig(pageSize = cnt),
            pagingSourceFactory = {
                listPageSource(cnt) { p, c ->
                    source.invoke(p, c)
                }
            }).flow

        fun <T : Any> pagerList(
            cnt: Int = 8,
            source: suspend (page: Int, cnt: Int) -> List<T>
        ) = pagerResult(cnt) { page, count ->
            try {
                Result.success(source(page, count))
            } catch (e: Exception) {
                Result.failure(e)
            }
        }

    }

}
package org.mjdev.balldontlie.base.helpers

import androidx.paging.PagingSource
import androidx.paging.PagingState

class ListPagingSource<T : Any>(
    private val perPage: Int = 50,
    private val source: (page: Int, perPage: Int) -> List<T>? = { _, _ -> emptyList() },
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
            val response = source.invoke(page, perPage) ?: emptyList()
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
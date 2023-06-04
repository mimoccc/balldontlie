package org.mjdev.balldontlie.base.helpers

import androidx.compose.runtime.Composable
import androidx.paging.PagingSource
import androidx.paging.PagingState
import org.mjdev.balldontlie.model.Player
import org.mjdev.balldontlie.repository.impl.MockedRepository

class ListPagingSource(
    private val perPage: Int = 50,
    private val source: (page: Int, perPage: Int) -> List<Player> = { p, c ->
        MockedRepository.MockRepository.players().players
    },
) : PagingSource<Int, Player>() {

    override fun getRefreshKey(state: PagingState<Int, Player>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Player> {
        return try {
            val page = params.key ?: 0
            val response = source.invoke(page, perPage)
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
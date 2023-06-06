package org.mjdev.balldontlie.base.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.itemContentType
import androidx.paging.compose.itemKey
import org.mjdev.balldontlie.base.annotations.DayPreview
import org.mjdev.balldontlie.base.helpers.Ext.previewData
import org.mjdev.balldontlie.base.helpers.ListPagingSource
import org.mjdev.balldontlie.base.helpers.SOURCE

@Suppress("UNUSED_ANONYMOUS_PARAMETER", "ModifierParameter")
@DayPreview
@Composable
fun <T : Any> PagingList(
    modifier: Modifier = previewData(Modifier) { Modifier.fillMaxSize() },
    verticalArrangement: Arrangement.HorizontalOrVertical = Arrangement.spacedBy(8.dp),
    perPage: Int = 50,
    source: SOURCE<T> = { p, c -> emptyList() },
    loadStateHandler: (state: LoadState) -> Unit = {},
    onItemClick: (data: T) -> Unit = { p -> },
    itemBlock: @Composable (
        idx: Int,
        item: T,
        onItemClick: (data: T) -> Unit
    ) -> Unit = { idx, item, onClick ->
    }
) {

    val listState = rememberLazyListState()

    val listData = remember {
        Pager(
            config = PagingConfig(
                pageSize = perPage,
                prefetchDistance = perPage,
                initialLoadSize = perPage
            ),
            pagingSourceFactory = {
                ListPagingSource(perPage, source)
            }
        ).flow
    }.collectAsLazyPagingItems().apply {
        loadStateHandler.invoke(loadState.refresh)
    }

    LazyColumn(
        modifier = modifier,
        verticalArrangement = verticalArrangement,
        state = listState
    ) {
        items(
            count = listData.itemCount,
            key = listData.itemKey(),
            contentType = listData.itemContentType()
        ) { index ->
            val item = listData[index]
            if (item != null) {
                itemBlock(index, item, onItemClick)
            }
        }
    }

}
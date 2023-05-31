package org.mjdev.moneta.base.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.paging.PagingData
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.itemContentType
import androidx.paging.compose.itemKey
import kotlinx.coroutines.flow.MutableStateFlow
import org.mjdev.moneta.mock.Mock

@Suppress("UNCHECKED_CAST", "UNUSED_ANONYMOUS_PARAMETER")
@Preview(showBackground = true)
@Composable
fun <T : Any> PagingList(
    modifier: Modifier = Modifier,
    verticalArrangement: Arrangement.HorizontalOrVertical = Arrangement.spacedBy(8.dp),
    data: LazyPagingItems<T>? = MutableStateFlow(PagingData.from(Mock.players()))
        .collectAsLazyPagingItems() as LazyPagingItems<T>,
    onItemClick: (data: T?) -> Unit = {},
    itemBlock: @Composable (
        idx: Int,
        item: T?,
        onItemClick: (data: T?) -> Unit
    ) -> Unit = { idx, item, onClick -> }
) {
    LazyColumn(
        modifier = modifier,
        verticalArrangement = verticalArrangement,
    ) {
        if (data != null) {
            items(
                count = data.itemCount,
                key = data.itemKey(),
                contentType = data.itemContentType()
            ) { index ->
                val item = data[index]
                itemBlock(index, item, onItemClick)
            }
        }
    }
}
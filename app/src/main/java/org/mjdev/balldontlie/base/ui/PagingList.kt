package org.mjdev.balldontlie.base.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.itemContentType
import androidx.paging.compose.itemKey
import org.mjdev.balldontlie.base.annotations.DayPreview
import org.mjdev.balldontlie.base.helpers.Ext.previewData


@Suppress("UNUSED_ANONYMOUS_PARAMETER", "ModifierParameter")
@DayPreview
@Composable
fun <T : Any> PagingList(
    modifier: Modifier = previewData(Modifier) { Modifier.fillMaxSize() },
    verticalArrangement: Arrangement.HorizontalOrVertical = Arrangement.spacedBy(8.dp),
    data: LazyPagingItems<T>? = null,
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
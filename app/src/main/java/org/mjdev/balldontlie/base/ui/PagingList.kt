package org.mjdev.balldontlie.base.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.itemContentType
import androidx.paging.compose.itemKey
import kotlinx.coroutines.runBlocking
import org.mjdev.balldontlie.base.annotations.DayPreview
import org.mjdev.balldontlie.base.helpers.Ext.asMutableFlow
import org.mjdev.balldontlie.base.helpers.Ext.previewData
import org.mjdev.balldontlie.base.helpers.ListPagingSource
import org.mjdev.balldontlie.model.Player
import org.mjdev.balldontlie.repository.impl.MockedRepository.Companion.MockRepository
import org.mjdev.balldontlie.ui.components.players.PlayerListItem

@Suppress("UNUSED_ANONYMOUS_PARAMETER", "ModifierParameter")
@DayPreview
@Composable
fun PagingList(
    modifier: Modifier = previewData(Modifier) { Modifier.fillMaxSize() },
    verticalArrangement: Arrangement.HorizontalOrVertical = Arrangement.spacedBy(8.dp),
    perPage: Int = 50,
    source: (page: Int, cnt: Int) -> List<Player> = { p, c ->
        MockRepository.players(p, c).players
    },
    onItemClick: (data: Player) -> Unit = { p -> },
    itemBlock: @Composable (
        idx: Int,
        item: Player,
        onItemClick: (data: Player) -> Unit
    ) -> Unit = { idx, item, onClick -> PlayerListItem(item) }
) {

//    val pagingConfig = remember { PagingConfig(pageSize = perPage) }
//    val pagingSource = remember { ListPagingSource(perPage, source) }

//    val listData = remember {
//        runBlocking {
//            Pager(
//                config = pagingConfig,
//                pagingSourceFactory = { pagingSource }
//            ).flow
//        }
//    }.collectAsLazyPagingItems()

    val listData = remember {
        source.invoke(0, 50).let { data ->
            PagingData.from(data).asMutableFlow()
        }
    }.collectAsLazyPagingItems()

    LazyColumn(
        modifier = modifier,
        verticalArrangement = verticalArrangement,
    ) {
        items(
            count = listData.itemCount,
            key = listData.itemKey(),
            contentType = listData.itemContentType()
        ) { index ->
            val item = listData[index]
            itemBlock(index, item!!, onItemClick)
        }
    }

}
package org.mjdev.moneta.ui.components.players

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.paging.PagingData
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import kotlinx.coroutines.flow.MutableStateFlow
import org.mjdev.moneta.model.Player
import org.mjdev.moneta.base.ui.PagingList
import org.mjdev.moneta.ui.theme.black
import org.mjdev.moneta.ui.theme.grayDark
import org.mjdev.moneta.ui.theme.grayLight

@Suppress("UNCHECKED_CAST")
@Preview(showBackground = true)
@Composable
fun PlayersList(
    playersData: LazyPagingItems<Player>? = MutableStateFlow(PagingData.from(listOf()))
        .collectAsLazyPagingItems() as? LazyPagingItems<Player>?,
    onItemClick: (data: Player?) -> Unit = {}
) {
    PagingList(
        verticalArrangement = Arrangement.spacedBy(4.dp),
        data = playersData,
        onItemClick = onItemClick
    ) { idx, player, onClick ->
        Box(
            modifier = Modifier.padding(4.dp, 0.dp, 4.dp, 0.dp)
        ) {
            PlayerListItem(
                idx = idx + 1,
                item = player,
                onItemClick = onClick,
                grayDark,
                grayLight,
                grayLight,
                black
            )
        }
    }
}
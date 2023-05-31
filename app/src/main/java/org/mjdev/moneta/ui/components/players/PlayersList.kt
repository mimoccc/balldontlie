package org.mjdev.moneta.ui.components.players

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import org.mjdev.moneta.model.Player
import org.mjdev.moneta.base.ui.PagingList
import org.mjdev.moneta.mock.Mock
import org.mjdev.moneta.ui.theme.black
import org.mjdev.moneta.ui.theme.grayDark
import org.mjdev.moneta.ui.theme.grayLight

@SuppressLint("ModifierParameter")
@Preview(showBackground = true)
@Composable
fun PlayersList(
    modifier: Modifier = Modifier.fillMaxSize(),
    playersData: LazyPagingItems<Player>? = Mock.playersFlow().collectAsLazyPagingItems(),
    onItemClick: (data: Player?) -> Unit = {}
) {
    PagingList(
        modifier = modifier,
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
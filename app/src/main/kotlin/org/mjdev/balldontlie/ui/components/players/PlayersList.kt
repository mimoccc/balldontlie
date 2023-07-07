package org.mjdev.balldontlie.ui.components.players

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import org.mjdev.balldontlie.base.annotations.DayPreview
import org.mjdev.balldontlie.base.helpers.Ext.previewData
import org.mjdev.balldontlie.base.helpers.SOURCE
import org.mjdev.balldontlie.base.ui.PagingList
import org.mjdev.balldontlie.model.Player
import org.mjdev.balldontlie.repository.impl.MockedRepository

@SuppressLint("ModifierParameter")
@DayPreview
@Composable
fun PlayersList(
    modifier: Modifier = previewData(Modifier) { Modifier.fillMaxSize() },
    perPage: Int = 25,
    source: SOURCE<Player> = { p, c ->
        MockedRepository.MockRepository.players(p, c).players
    },
    loadStateHandler: (state: LoadState) -> Unit = {},
    onItemClick: (data: Player) -> Unit = {}
) {

    PagingList(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(4.dp),
        perPage = perPage,
        source = source,
        loadStateHandler = loadStateHandler,
        onItemClick = onItemClick
    ) { _, player, onClick ->

        Box(
            modifier = Modifier.padding(4.dp, 0.dp, 4.dp, 0.dp)
        ) {
            PlayerListItem(
                item = player,
                onItemClick = onClick
            )
        }

    }

}
@file:Suppress("MemberVisibilityCanBePrivate")

package org.mjdev.moneta.mock

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.paging.PagingData
import kotlinx.coroutines.flow.MutableStateFlow
import org.mjdev.moneta.model.Player
import org.mjdev.moneta.model.Team

object Mock {

    private const val DEFAULT_COUNT_OF_PLAYERS = 25L

    @Suppress("UNUSED_PARAMETER")
    fun players(
        page: Long = 0,
        cnt: Long = DEFAULT_COUNT_OF_PLAYERS
    ): List<Player> = mutableListOf<Player>().apply {
        (1..cnt + 1).forEach { idx ->
            add(player(idx.toInt(), "$idx"))
        }
    }

    fun team() = Team(
        id = 9,
        name = "mock team",
        fullName = "mocked team",
        division = "team division",
        abbreviation = "team abbreviation",
        conference = "team conference",
        city = "London UK",
    )

    fun player(
        idx: Int? = null,
        lastName: String? = "Player $idx"
    ) = Player(
        id = idx ?: 143,
        firstName = "player",
        lastName = lastName ?: "1",
        position = "G",
        team = team(),
        heightFeet = 123,
        heightInches = 12,
        weightPounds = 89,
    )

    fun playersFlow(
        page: Long = 0,
        cnt: Long = DEFAULT_COUNT_OF_PLAYERS
    ): MutableStateFlow<PagingData<Player>> = MutableStateFlow(
        PagingData.from(players(page, cnt))
    )

    fun playerState(idx: Int): State<Player?> = mutableStateOf(player(idx))

}
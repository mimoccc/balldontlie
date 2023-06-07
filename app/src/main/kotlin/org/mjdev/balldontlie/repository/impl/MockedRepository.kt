package org.mjdev.balldontlie.repository.impl

import org.mjdev.balldontlie.model.Meta
import org.mjdev.balldontlie.model.Player
import org.mjdev.balldontlie.model.Players
import org.mjdev.balldontlie.model.Team
import org.mjdev.balldontlie.repository.def.IRepository

class MockedRepository : IRepository {

    @Suppress("PropertyName", "MemberVisibilityCanBePrivate")
    val DEFAULT_COUNT_OF_PLAYERS = 50

    fun player(
        idx: Long = 0L,
    ) = Player(
        id = idx,
        firstName = "Player",
        lastName = "1",
        position = "G",
        team = team(),
        heightFeet = 123,
        heightInches = 12,
        weightPounds = 89,
    ).apply {
        fullName = "Player $idx"
    }

    fun players(
        page: Int = 0,
        perPage: Int = DEFAULT_COUNT_OF_PLAYERS
    ): Players = Players(
        players = mutableListOf<Player>().apply {
            (1..perPage + 1).forEach { idx ->
                add(player(idx.toLong()))
            }
        },
        meta = Meta(
            currentPage = page,
            nextPage = page + 1,
            perPage = perPage,
            totalCount = perPage,
            totalPages = 1
        )
    )

    private fun team() = Team(
        id = 9,
        name = "mock team",
        fullName = "mocked team",
        division = "team division",
        abbreviation = "team abbreviation",
        conference = "team conference",
        city = "London UK",
    )

    override suspend fun getPlayers(
        page: Int,
        perPage: Int,
    ): Result<Players> = Result.success(players(0, perPage))

    override suspend fun getPlayer(
        id: Int
    ): Result<Player> = Result.success(player(id.toLong()))

    companion object {
        val MockRepository by lazy { MockedRepository() }
    }

}
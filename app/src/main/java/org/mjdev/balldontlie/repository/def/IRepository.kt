package org.mjdev.balldontlie.repository.def

import kotlinx.coroutines.flow.Flow
import org.mjdev.balldontlie.model.Player
import org.mjdev.balldontlie.model.Players

interface IRepository {

    suspend fun getPlayers(
        page: Int = 0,
        perPage: Int = 50,
    ): Result<Flow<Players>>

    suspend fun getPlayer(
        id: Int
    ): Result<Flow<Player>>

}
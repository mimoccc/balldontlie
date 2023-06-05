package org.mjdev.balldontlie.repository.def

import org.mjdev.balldontlie.model.Player
import org.mjdev.balldontlie.model.Players

interface INetworkRepository  {

    suspend fun getPlayers(
        page: Int = 0,
        perPage: Int = 8,
    ): Result<Players>

    suspend fun getPlayer(
        id: Int
    ): Result<Player>

}
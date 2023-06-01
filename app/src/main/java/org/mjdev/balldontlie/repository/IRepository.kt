package org.mjdev.balldontlie.repository

import org.mjdev.balldontlie.model.Player
import org.mjdev.balldontlie.model.Players

interface IRepository {

    suspend fun getPlayers(
        page: Int = 0,
        perPage: Int = 8,
    ): Result<Players>

    suspend fun getPlayer(
        id: Int
    ): Result<Player>

}
package org.mjdev.moneta.repository

import org.mjdev.moneta.model.Player
import org.mjdev.moneta.model.Players

interface IRepository {

    suspend fun getPlayers(
        page: Int = 0,
        perPage: Int = 8,
    ): Result<Players>

    suspend fun getPlayer(
        id: Int
    ): Result<Player>

}
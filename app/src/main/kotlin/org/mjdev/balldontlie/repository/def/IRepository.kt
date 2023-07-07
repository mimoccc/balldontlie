package org.mjdev.balldontlie.repository.def

import org.mjdev.balldontlie.model.Player
import org.mjdev.balldontlie.model.Players

interface IRepository {

    suspend fun getPlayers(
        page: Int = 0,
        perPage: Int = 50,
    ): Result<Players>

    suspend fun getPlayer(
        id: Int
    ): Result<Player>

    companion object {

        fun <T> runSafe(block: () -> T): Result<T> = try {
            Result.success(block.invoke())
        } catch (e: Exception) {
            Result.failure(e)
        }

    }

}
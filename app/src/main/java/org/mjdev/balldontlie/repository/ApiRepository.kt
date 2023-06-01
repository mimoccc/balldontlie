package org.mjdev.balldontlie.repository

import org.mjdev.balldontlie.error.ApiError
import org.mjdev.balldontlie.model.Player
import org.mjdev.balldontlie.model.Players
import org.mjdev.balldontlie.network.ApiService
import retrofit2.Response

class ApiRepository(
    private val apiService: ApiService
) : IRepository {

    override suspend fun getPlayers(
        page: Int,
        perPage: Int,
    ): Result<Players> = call {
        apiService.getPlayersAsync(page, perPage).await()
    }

    override suspend fun getPlayer(
        id: Int
    ): Result<Player> = call {
        apiService.getPlayerAsync(id).await()
    }

    private suspend fun <T> call(body: suspend () -> Response<T>): Result<T> {
        val response = body.invoke()
        return if (response.isSuccessful) {
            val data = response.body()
            if (data == null) {
                Result.failure(ApiError("Empty response for players."))
            } else {
                Result.success(data)
            }
        } else {
            Result.failure(ApiError(response))
        }
    }

}
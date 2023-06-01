package org.mjdev.moneta.repository

import org.mjdev.moneta.error.ApiError
import org.mjdev.moneta.model.Player
import org.mjdev.moneta.model.Players
import org.mjdev.moneta.network.ApiService
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
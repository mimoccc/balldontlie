package org.mjdev.moneta.repository

import org.mjdev.moneta.error.ApiError
import org.mjdev.moneta.model.Player
import org.mjdev.moneta.model.Players
import org.mjdev.moneta.network.ApiService
import retrofit2.Response

class ApiRepository(
    private val apiService: ApiService
) {

    suspend fun getPlayers(
        page: Long = 0,
        perPage: Long = 8,
    ): Result<Players> = call {
        apiService.getPlayersAsync(page, perPage).await()
    }

    suspend fun getPlayer(
        id: Long
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
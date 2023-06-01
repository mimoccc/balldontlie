package org.mjdev.moneta.network

import kotlinx.coroutines.Deferred
import org.mjdev.moneta.model.Player
import org.mjdev.moneta.model.Players
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("players/")
    fun getPlayersAsync(
        @Query("page") page: Int = 0,
        @Query("per_page") perPage: Int = 25,
    ): Deferred<Response<Players>>

    @GET("players/{id}")
    fun getPlayerAsync(
        @Path("id") id: Int
    ): Deferred<Response<Player>>

}
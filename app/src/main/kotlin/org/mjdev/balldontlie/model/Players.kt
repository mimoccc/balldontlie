package org.mjdev.balldontlie.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Players(

    @Json(name = "data")
    val players: List<Player> = listOf(),

    @Json(name = "meta")
    val meta: Meta = Meta()

)
package org.mjdev.balldontlie.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Team(

    @Json(name = "id")
    val id: Int? = null,

    @Json(name = "name")
    val name: String? = null,

    @Json(name = "full_name")
    val fullName: String? = null,

    @Json(name = "division")
    val division: String? = null,

    @Json(name = "abbreviation")
    val abbreviation: String? = null,

    @Json(name = "conference")
    val conference: String? = null,

    @Json(name = "city")
    val city: String? = null,

)
package org.mjdev.moneta.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Player(

    @Json(name = "id")
    val id: Int? = null,

    @Json(name = "first_name")
    var firstName: String? = null,

    @Json(name = "last_name")
    var lastName: String? = null,

    @Json(name = "position")
    val position: String? = null,

    @Json(name = "team")
    val team: Team = Team(),

    @Json(name = "height_feet")
    val heightFeet: Int? = null,

    @Json(name = "height_inches")
    val heightInches: Int? = null,

    @Json(name = "weight_pounds")
    val weightPounds: Int? = null,

    ) {

    var fullName: String
        get() = "${if (firstName == null) "" else firstName} ${if (lastName == null) "" else lastName}".trim()
        set(value) {
            value.split(" ").also { pair ->
                firstName = if (pair.isNotEmpty()) pair[0] else ""
                lastName = if (pair.size > 1) pair[1] else ""
            }
        }

    fun isEmpty() = (id == null)

}
package org.mjdev.balldontlie.model

import com.j256.ormlite.field.DatabaseField
import com.j256.ormlite.table.DatabaseTable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@DatabaseTable(tableName = "player")
@JsonClass(generateAdapter = true)
data class Player(

    @DatabaseField(id=true, generatedId = false, unique=true)
    @Json(name = "id")
    val id: Int? = null,

    @DatabaseField(index = true)
    @Json(name = "first_name")
    var firstName: String? = null,

    @DatabaseField(index = true)
    @Json(name = "last_name")
    var lastName: String? = null,

    @DatabaseField(index = false)
    @Json(name = "position")
    val position: String? = null,

    @DatabaseField(
        index = false,
        foreign = true,
        foreignAutoCreate = true,
        foreignAutoRefresh = true
    )
    @Json(name = "team")
    val team: Team = Team(),

    @DatabaseField(index = false)
    @Json(name = "height_feet")
    val heightFeet: Int? = null,

    @DatabaseField(index = false)
    @Json(name = "height_inches")
    val heightInches: Int? = null,

    @DatabaseField(index = false)
    @Json(name = "weight_pounds")
    val weightPounds: Int? = null,

    ) {

    var fullName: String
        get() {
            val fn = if (firstName == null) "" else firstName
            val ln = if (lastName == null) "" else lastName
            return "$fn $ln".trim()
        }
        set(value) {
            value.split(" ").also { pair ->
                firstName = if (pair.isNotEmpty()) pair[0] else ""
                lastName = if (pair.size > 1) pair[1] else ""
            }
        }

    fun isEmpty() = (id == null)

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as Player
        if (id != other.id) return false
        if (firstName != other.firstName) return false
        if (lastName != other.lastName) return false
        if (position != other.position) return false
        if (team != other.team) return false
        if (heightFeet != other.heightFeet) return false
        if (heightInches != other.heightInches) return false
        if (weightPounds != other.weightPounds) return false
        return true
    }

    override fun hashCode(): Int {
        var result = id ?: 0
        result = 31 * result + (firstName?.hashCode() ?: 0)
        result = 31 * result + (lastName?.hashCode() ?: 0)
        result = 31 * result + (position?.hashCode() ?: 0)
        result = 31 * result + team.hashCode()
        result = 31 * result + (heightFeet ?: 0)
        result = 31 * result + (heightInches ?: 0)
        result = 31 * result + (weightPounds ?: 0)
        return result
    }

}
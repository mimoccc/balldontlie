package org.mjdev.balldontlie.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import io.objectbox.annotation.Convert
import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import org.mjdev.balldontlie.model.convert.EncryptionConverter
import org.mjdev.balldontlie.model.convert.TeamConverter

@Entity
@JsonClass(generateAdapter = true)
data class Player(

    @Id
    @Json(name = "id")
    var id: Long = 0,

    @Convert(converter = EncryptionConverter::class, dbType = String::class)
    @Json(name = "first_name")
    var firstName: String? = null,

    @Convert(converter = EncryptionConverter::class, dbType = String::class)
    @Json(name = "last_name")
    var lastName: String? = null,

    @Convert(converter = EncryptionConverter::class, dbType = String::class)
    @Json(name = "position")
    var position: String? = null,

    @Convert(converter = TeamConverter::class, dbType = Long::class)
    @Json(name = "team")
    var team: Team = Team(),

    @Json(name = "height_feet")
    var heightFeet: Int? = null,

    @Json(name = "height_inches")
    var heightInches: Int? = null,

    @Json(name = "weight_pounds")
    var weightPounds: Int? = null,

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

    fun isEmpty() = (id == 0L)

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
        var result = id.toInt()
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
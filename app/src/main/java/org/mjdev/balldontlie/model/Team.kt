package org.mjdev.balldontlie.model

import com.j256.ormlite.field.DatabaseField
import com.j256.ormlite.table.DatabaseTable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@DatabaseTable(tableName = "team")
@JsonClass(generateAdapter = true)
data class Team(

    @DatabaseField(id=true, generatedId = false, unique=true)
    @Json(name = "id")
    val id: Int? = null,

    @DatabaseField(index = true)
    @Json(name = "name")
    val name: String? = null,

    @DatabaseField(index = true)
    @Json(name = "full_name")
    val fullName: String? = null,

    @DatabaseField(index = false)
    @Json(name = "division")
    val division: String? = null,

    @DatabaseField(index = false)
    @Json(name = "abbreviation")
    val abbreviation: String? = null,

    @DatabaseField(index = false)
    @Json(name = "conference")
    val conference: String? = null,

    @DatabaseField(index = true)
    @Json(name = "city")
    val city: String? = null,

) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as Team
        if (id != other.id) return false
        if (name != other.name) return false
        if (fullName != other.fullName) return false
        if (division != other.division) return false
        if (abbreviation != other.abbreviation) return false
        if (conference != other.conference) return false
        if (city != other.city) return false
        return true
    }

    override fun hashCode(): Int {
        var result = id ?: 0
        result = 31 * result + (name?.hashCode() ?: 0)
        result = 31 * result + (fullName?.hashCode() ?: 0)
        result = 31 * result + (division?.hashCode() ?: 0)
        result = 31 * result + (abbreviation?.hashCode() ?: 0)
        result = 31 * result + (conference?.hashCode() ?: 0)
        result = 31 * result + (city?.hashCode() ?: 0)
        return result
    }

}
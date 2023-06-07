package org.mjdev.balldontlie.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import io.objectbox.annotation.Convert
import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import org.mjdev.balldontlie.model.convert.ConvertEntity
import org.mjdev.balldontlie.model.convert.EncryptionConverter

@Entity
@JsonClass(generateAdapter = true)
data class Team(

    @Id
    @Json(name = "id")
    override var id: Long = 0L,

    @Convert(converter = EncryptionConverter::class, dbType = String::class)
    @Json(name = "name")
    var name: String? = null,

    @Convert(converter = EncryptionConverter::class, dbType = String::class)
    @Json(name = "full_name")
    var fullName: String? = null,

    @Convert(converter = EncryptionConverter::class, dbType = String::class)
    @Json(name = "division")
    var division: String? = null,

    @Convert(converter = EncryptionConverter::class, dbType = String::class)
    @Json(name = "abbreviation")
    var abbreviation: String? = null,

    @Convert(converter = EncryptionConverter::class, dbType = String::class)
    @Json(name = "conference")
    var conference: String? = null,

    @Convert(converter = EncryptionConverter::class, dbType = String::class)
    @Json(name = "city")
    var city: String? = null,

    ) : ConvertEntity() {

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
        var result = id.toInt()
        result = 31 * result + (name?.hashCode() ?: 0)
        result = 31 * result + (fullName?.hashCode() ?: 0)
        result = 31 * result + (division?.hashCode() ?: 0)
        result = 31 * result + (abbreviation?.hashCode() ?: 0)
        result = 31 * result + (conference?.hashCode() ?: 0)
        result = 31 * result + (city?.hashCode() ?: 0)
        return result
    }

}

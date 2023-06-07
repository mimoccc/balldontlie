package org.mjdev.balldontlie.model.convert

import io.objectbox.converter.PropertyConverter

open class ConvertEntity : Any() {
    open val id: Long = 0L
}

open class CustomPropertyConverter<T : ConvertEntity>(
    private val supplier: (id: Long) -> T?
) : PropertyConverter<T, Long> {

    override fun convertToEntityProperty(databaseValue: Long?): T? =
        if (databaseValue == null) null
        else supplier.invoke(databaseValue)

    override fun convertToDatabaseValue(entityProperty: T): Long =
        entityProperty.id

}
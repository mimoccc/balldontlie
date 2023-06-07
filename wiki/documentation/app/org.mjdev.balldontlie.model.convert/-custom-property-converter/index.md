//[app](../../../index.md)/[org.mjdev.balldontlie.model.convert](../index.md)/[CustomPropertyConverter](index.md)

# CustomPropertyConverter

open class [CustomPropertyConverter](index.md)&lt;[T](index.md) : [ConvertEntity](../-convert-entity/index.md)&gt;(supplier: (id: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)) -&gt; [T](index.md)?) : PropertyConverter&lt;[T](index.md), [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)&gt; 

#### Inheritors

| |
|---|
| [TeamConverter](../-team-converter/index.md) |

## Constructors

| | |
|---|---|
| [CustomPropertyConverter](-custom-property-converter.md) | [androidJvm]<br>constructor(supplier: (id: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)) -&gt; [T](index.md)?) |

## Functions

| Name | Summary |
|---|---|
| [convertToDatabaseValue](convert-to-database-value.md) | [androidJvm]<br>open override fun [convertToDatabaseValue](convert-to-database-value.md)(entityProperty: [T](index.md)): [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) |
| [convertToEntityProperty](convert-to-entity-property.md) | [androidJvm]<br>open override fun [convertToEntityProperty](convert-to-entity-property.md)(databaseValue: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)?): [T](index.md)? |

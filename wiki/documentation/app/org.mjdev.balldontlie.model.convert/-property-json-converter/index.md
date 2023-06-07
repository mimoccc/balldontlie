//[app](../../../index.md)/[org.mjdev.balldontlie.model.convert](../index.md)/[PropertyJsonConverter](index.md)

# PropertyJsonConverter

[androidJvm]\
open class [PropertyJsonConverter](index.md)&lt;[T](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt;(cls: [Class](https://developer.android.com/reference/kotlin/java/lang/Class.html)&lt;[T](index.md)&gt;) : PropertyConverter&lt;[T](index.md), [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)&gt;

## Constructors

| | |
|---|---|
| [PropertyJsonConverter](-property-json-converter.md) | [androidJvm]<br>constructor(cls: [Class](https://developer.android.com/reference/kotlin/java/lang/Class.html)&lt;[T](index.md)&gt;) |

## Functions

| Name | Summary |
|---|---|
| [convertToDatabaseValue](convert-to-database-value.md) | [androidJvm]<br>open override fun [convertToDatabaseValue](convert-to-database-value.md)(entityProperty: [T](index.md)?): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? |
| [convertToEntityProperty](convert-to-entity-property.md) | [androidJvm]<br>open override fun [convertToEntityProperty](convert-to-entity-property.md)(databaseValue: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?): [T](index.md)? |

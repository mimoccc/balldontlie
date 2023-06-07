//[app](../../../index.md)/[org.mjdev.balldontlie.model.convert](../index.md)/[PropertyEnumConverter](index.md)

# PropertyEnumConverter

[androidJvm]\
open class [PropertyEnumConverter](index.md)&lt;[T](index.md), [R](index.md)&gt;(values: [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)&lt;[T](index.md)&gt;, default: [T](index.md), predicate: [T](index.md).([R](index.md)) -&gt; [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html), supplier: ([T](index.md)) -&gt; [R](index.md)?) : PropertyConverter&lt;[T](index.md), [R](index.md)&gt;

## Constructors

| | |
|---|---|
| [PropertyEnumConverter](-property-enum-converter.md) | [androidJvm]<br>constructor(values: [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)&lt;[T](index.md)&gt;, default: [T](index.md), predicate: [T](index.md).([R](index.md)) -&gt; [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html), supplier: ([T](index.md)) -&gt; [R](index.md)?) |

## Functions

| Name | Summary |
|---|---|
| [convertToDatabaseValue](convert-to-database-value.md) | [androidJvm]<br>open override fun [convertToDatabaseValue](convert-to-database-value.md)(entityProperty: [T](index.md)?): [R](index.md)? |
| [convertToEntityProperty](convert-to-entity-property.md) | [androidJvm]<br>open override fun [convertToEntityProperty](convert-to-entity-property.md)(databaseValue: [R](index.md)?): [T](index.md)? |

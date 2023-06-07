//[app](../../../index.md)/[org.mjdev.balldontlie.model.convert](../index.md)/[TeamConverter](index.md)

# TeamConverter

[androidJvm]\
class [TeamConverter](index.md)(supplier: (id: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)) -&gt; [Team](../../org.mjdev.balldontlie.model/-team/index.md)? = { id -&gt;
        MyObjectBox.builder().build().boxFor&lt;Team&gt;().get(id)
    }) : [CustomPropertyConverter](../-custom-property-converter/index.md)&lt;[Team](../../org.mjdev.balldontlie.model/-team/index.md)&gt;

## Constructors

| | |
|---|---|
| [TeamConverter](-team-converter.md) | [androidJvm]<br>constructor(supplier: (id: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)) -&gt; [Team](../../org.mjdev.balldontlie.model/-team/index.md)? = { id -&gt;         MyObjectBox.builder().build().boxFor&lt;Team&gt;().get(id)     }) |

## Functions

| Name | Summary |
|---|---|
| [convertToDatabaseValue](index.md#2085698033%2FFunctions%2F-912451524) | [androidJvm]<br>open override fun [convertToDatabaseValue](index.md#2085698033%2FFunctions%2F-912451524)(entityProperty: [Team](../../org.mjdev.balldontlie.model/-team/index.md)): [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) |
| [convertToEntityProperty](../-custom-property-converter/convert-to-entity-property.md) | [androidJvm]<br>open override fun [convertToEntityProperty](../-custom-property-converter/convert-to-entity-property.md)(databaseValue: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)?): [Team](../../org.mjdev.balldontlie.model/-team/index.md)? |

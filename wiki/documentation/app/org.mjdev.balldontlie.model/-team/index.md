//[app](../../../index.md)/[org.mjdev.balldontlie.model](../index.md)/[Team](index.md)

# Team

[androidJvm]\
@JsonClass(generateAdapter = true)

data class [Team](index.md)(@Json(name = &quot;id&quot;)var id: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) = 0, @Json(name = &quot;name&quot;)var name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, @Json(name = &quot;full_name&quot;)var fullName: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, @Json(name = &quot;division&quot;)var division: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, @Json(name = &quot;abbreviation&quot;)var abbreviation: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, @Json(name = &quot;conference&quot;)var conference: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, @Json(name = &quot;city&quot;)var city: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null) : [ConvertEntity](../../org.mjdev.balldontlie.model.convert/-convert-entity/index.md)

## Constructors

| | |
|---|---|
| [Team](-team.md) | [androidJvm]<br>constructor(@Json(name = &quot;id&quot;)id: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) = 0, @Json(name = &quot;name&quot;)name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, @Json(name = &quot;full_name&quot;)fullName: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, @Json(name = &quot;division&quot;)division: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, @Json(name = &quot;abbreviation&quot;)abbreviation: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, @Json(name = &quot;conference&quot;)conference: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, @Json(name = &quot;city&quot;)city: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null) |

## Functions

| Name | Summary |
|---|---|
| [equals](equals.md) | [androidJvm]<br>open operator override fun [equals](equals.md)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [hashCode](hash-code.md) | [androidJvm]<br>open override fun [hashCode](hash-code.md)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |

## Properties

| Name | Summary |
|---|---|
| [abbreviation](abbreviation.md) | [androidJvm]<br>var [abbreviation](abbreviation.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? |
| [city](city.md) | [androidJvm]<br>var [city](city.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? |
| [conference](conference.md) | [androidJvm]<br>var [conference](conference.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? |
| [division](division.md) | [androidJvm]<br>var [division](division.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? |
| [fullName](full-name.md) | [androidJvm]<br>var [fullName](full-name.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? |
| [id](id.md) | [androidJvm]<br>open override var [id](id.md): [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) |
| [name](name.md) | [androidJvm]<br>var [name](name.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? |

//[app](../../../index.md)/[org.mjdev.balldontlie.model](../index.md)/[Player](index.md)

# Player

[androidJvm]\
@JsonClass(generateAdapter = true)

data class [Player](index.md)(@Json(name = &quot;id&quot;)var id: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) = 0, @Json(name = &quot;first_name&quot;)var firstName: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, @Json(name = &quot;last_name&quot;)var lastName: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, @Json(name = &quot;position&quot;)var position: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, @Json(name = &quot;team&quot;)var team: [Team](../-team/index.md) = Team(), @Json(name = &quot;height_feet&quot;)var heightFeet: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)? = null, @Json(name = &quot;height_inches&quot;)var heightInches: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)? = null, @Json(name = &quot;weight_pounds&quot;)var weightPounds: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)? = null)

## Constructors

| | |
|---|---|
| [Player](-player.md) | [androidJvm]<br>constructor(@Json(name = &quot;id&quot;)id: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) = 0, @Json(name = &quot;first_name&quot;)firstName: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, @Json(name = &quot;last_name&quot;)lastName: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, @Json(name = &quot;position&quot;)position: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, @Json(name = &quot;team&quot;)team: [Team](../-team/index.md) = Team(), @Json(name = &quot;height_feet&quot;)heightFeet: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)? = null, @Json(name = &quot;height_inches&quot;)heightInches: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)? = null, @Json(name = &quot;weight_pounds&quot;)weightPounds: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)? = null) |

## Functions

| Name | Summary |
|---|---|
| [equals](equals.md) | [androidJvm]<br>open operator override fun [equals](equals.md)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [hashCode](hash-code.md) | [androidJvm]<br>open override fun [hashCode](hash-code.md)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [isEmpty](is-empty.md) | [androidJvm]<br>fun [isEmpty](is-empty.md)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |

## Properties

| Name | Summary |
|---|---|
| [firstName](first-name.md) | [androidJvm]<br>var [firstName](first-name.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? |
| [fullName](full-name.md) | [androidJvm]<br>var [fullName](full-name.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [heightFeet](height-feet.md) | [androidJvm]<br>var [heightFeet](height-feet.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)? |
| [heightInches](height-inches.md) | [androidJvm]<br>var [heightInches](height-inches.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)? |
| [id](id.md) | [androidJvm]<br>var [id](id.md): [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) |
| [lastName](last-name.md) | [androidJvm]<br>var [lastName](last-name.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? |
| [position](position.md) | [androidJvm]<br>var [position](position.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? |
| [team](team.md) | [androidJvm]<br>var [team](team.md): [Team](../-team/index.md) |
| [weightPounds](weight-pounds.md) | [androidJvm]<br>var [weightPounds](weight-pounds.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)? |

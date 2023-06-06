//[app](../../../index.md)/[org.mjdev.balldontlie.model](../index.md)/[Player](index.md)

# Player

[androidJvm]\
@JsonClass(generateAdapter = true)

data class [Player](index.md)(@Json(name = &quot;id&quot;)val id: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)? = null, @Json(name = &quot;first_name&quot;)var firstName: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, @Json(name = &quot;last_name&quot;)var lastName: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, @Json(name = &quot;position&quot;)val position: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, @Json(name = &quot;team&quot;)val team: [Team](../-team/index.md) = Team(), @Json(name = &quot;height_feet&quot;)val heightFeet: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)? = null, @Json(name = &quot;height_inches&quot;)val heightInches: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)? = null, @Json(name = &quot;weight_pounds&quot;)val weightPounds: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)? = null)

## Constructors

| | |
|---|---|
| [Player](-player.md) | [androidJvm]<br>constructor(@Json(name = &quot;id&quot;)id: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)? = null, @Json(name = &quot;first_name&quot;)firstName: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, @Json(name = &quot;last_name&quot;)lastName: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, @Json(name = &quot;position&quot;)position: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, @Json(name = &quot;team&quot;)team: [Team](../-team/index.md) = Team(), @Json(name = &quot;height_feet&quot;)heightFeet: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)? = null, @Json(name = &quot;height_inches&quot;)heightInches: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)? = null, @Json(name = &quot;weight_pounds&quot;)weightPounds: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)? = null) |

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
| [heightFeet](height-feet.md) | [androidJvm]<br>val [heightFeet](height-feet.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)? = null |
| [heightInches](height-inches.md) | [androidJvm]<br>val [heightInches](height-inches.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)? = null |
| [id](id.md) | [androidJvm]<br>val [id](id.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)? = null |
| [lastName](last-name.md) | [androidJvm]<br>var [lastName](last-name.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? |
| [position](position.md) | [androidJvm]<br>val [position](position.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null |
| [team](team.md) | [androidJvm]<br>val [team](team.md): [Team](../-team/index.md) |
| [weightPounds](weight-pounds.md) | [androidJvm]<br>val [weightPounds](weight-pounds.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)? = null |

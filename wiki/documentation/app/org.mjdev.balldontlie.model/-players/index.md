//[app](../../../index.md)/[org.mjdev.balldontlie.model](../index.md)/[Players](index.md)

# Players

[androidJvm]\
@JsonClass(generateAdapter = true)

data class [Players](index.md)(@Json(name = &quot;data&quot;)val players: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[Player](../-player/index.md)&gt; = listOf(), @Json(name = &quot;meta&quot;)val meta: [Meta](../-meta/index.md) = Meta())

## Constructors

| | |
|---|---|
| [Players](-players.md) | [androidJvm]<br>constructor(@Json(name = &quot;data&quot;)players: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[Player](../-player/index.md)&gt; = listOf(), @Json(name = &quot;meta&quot;)meta: [Meta](../-meta/index.md) = Meta()) |

## Properties

| Name | Summary |
|---|---|
| [meta](meta.md) | [androidJvm]<br>val [meta](meta.md): [Meta](../-meta/index.md) |
| [players](players.md) | [androidJvm]<br>val [players](players.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[Player](../-player/index.md)&gt; |

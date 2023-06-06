//[app](../../../index.md)/[org.mjdev.balldontlie.network](../index.md)/[ApiService](index.md)

# ApiService

[androidJvm]\
interface [ApiService](index.md)

## Functions

| Name | Summary |
|---|---|
| [getPlayerAsync](get-player-async.md) | [androidJvm]<br>@GET(value = &quot;players/{id}&quot;)<br>abstract fun [getPlayerAsync](get-player-async.md)(@Path(value = &quot;id&quot;)id: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): Deferred&lt;Response&lt;[Player](../../org.mjdev.balldontlie.model/-player/index.md)&gt;&gt; |
| [getPlayersAsync](get-players-async.md) | [androidJvm]<br>@GET(value = &quot;players/&quot;)<br>abstract fun [getPlayersAsync](get-players-async.md)(@Query(value = &quot;page&quot;)page: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 0, @Query(value = &quot;per_page&quot;)perPage: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 25): Deferred&lt;Response&lt;[Players](../../org.mjdev.balldontlie.model/-players/index.md)&gt;&gt; |

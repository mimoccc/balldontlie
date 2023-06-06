//[app](../../../index.md)/[org.mjdev.balldontlie.network](../index.md)/[ApiService](index.md)/[getPlayersAsync](get-players-async.md)

# getPlayersAsync

[androidJvm]\

@GET(value = &quot;players/&quot;)

abstract fun [getPlayersAsync](get-players-async.md)(@Query(value = &quot;page&quot;)page: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 0, @Query(value = &quot;per_page&quot;)perPage: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 25): Deferred&lt;Response&lt;[Players](../../org.mjdev.balldontlie.model/-players/index.md)&gt;&gt;

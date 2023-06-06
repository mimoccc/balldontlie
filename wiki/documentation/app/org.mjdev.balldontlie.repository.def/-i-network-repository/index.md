//[app](../../../index.md)/[org.mjdev.balldontlie.repository.def](../index.md)/[INetworkRepository](index.md)

# INetworkRepository

interface [INetworkRepository](index.md)

#### Inheritors

| |
|---|
| [ApiRepository](../../org.mjdev.balldontlie.repository.impl/-api-repository/index.md) |

## Functions

| Name | Summary |
|---|---|
| [getPlayer](get-player.md) | [androidJvm]<br>abstract suspend fun [getPlayer](get-player.md)(id: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): [Result](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-result/index.html)&lt;[Player](../../org.mjdev.balldontlie.model/-player/index.md)&gt; |
| [getPlayers](get-players.md) | [androidJvm]<br>abstract suspend fun [getPlayers](get-players.md)(page: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 0, perPage: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 8): [Result](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-result/index.html)&lt;[Players](../../org.mjdev.balldontlie.model/-players/index.md)&gt; |

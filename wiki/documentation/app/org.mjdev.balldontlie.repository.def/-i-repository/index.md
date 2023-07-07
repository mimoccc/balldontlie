//[app](../../../index.md)/[org.mjdev.balldontlie.repository.def](../index.md)/[IRepository](index.md)

# IRepository

interface [IRepository](index.md)

#### Inheritors

| |
|---|
| [MockedRepository](../../org.mjdev.balldontlie.repository.impl/-mocked-repository/index.md) |
| [SyncRepository](../../org.mjdev.balldontlie.repository.impl/-sync-repository/index.md) |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [androidJvm]<br>object [Companion](-companion/index.md) |

## Functions

| Name | Summary |
|---|---|
| [getPlayer](get-player.md) | [androidJvm]<br>abstract suspend fun [getPlayer](get-player.md)(id: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): [Result](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-result/index.html)&lt;[Player](../../org.mjdev.balldontlie.model/-player/index.md)&gt; |
| [getPlayers](get-players.md) | [androidJvm]<br>abstract suspend fun [getPlayers](get-players.md)(page: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 0, perPage: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 50): [Result](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-result/index.html)&lt;[Players](../../org.mjdev.balldontlie.model/-players/index.md)&gt; |

//[app](../../../index.md)/[org.mjdev.balldontlie.repository.impl](../index.md)/[MockedRepository](index.md)

# MockedRepository

[androidJvm]\
class [MockedRepository](index.md) : [IRepository](../../org.mjdev.balldontlie.repository.def/-i-repository/index.md)

## Constructors

| | |
|---|---|
| [MockedRepository](-mocked-repository.md) | [androidJvm]<br>constructor() |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [androidJvm]<br>object [Companion](-companion/index.md) |

## Functions

| Name | Summary |
|---|---|
| [getPlayer](get-player.md) | [androidJvm]<br>open suspend override fun [getPlayer](get-player.md)(id: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): [Result](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-result/index.html)&lt;[Player](../../org.mjdev.balldontlie.model/-player/index.md)&gt; |
| [getPlayers](get-players.md) | [androidJvm]<br>open suspend override fun [getPlayers](get-players.md)(page: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), perPage: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): [Result](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-result/index.html)&lt;[Players](../../org.mjdev.balldontlie.model/-players/index.md)&gt; |
| [player](player.md) | [androidJvm]<br>fun [player](player.md)(idx: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) = 0): [Player](../../org.mjdev.balldontlie.model/-player/index.md) |
| [players](players.md) | [androidJvm]<br>fun [players](players.md)(page: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 0, perPage: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = DEFAULT_COUNT_OF_PLAYERS): [Players](../../org.mjdev.balldontlie.model/-players/index.md) |

## Properties

| Name | Summary |
|---|---|
| [DEFAULT_COUNT_OF_PLAYERS](-d-e-f-a-u-l-t_-c-o-u-n-t_-o-f_-p-l-a-y-e-r-s.md) | [androidJvm]<br>val [DEFAULT_COUNT_OF_PLAYERS](-d-e-f-a-u-l-t_-c-o-u-n-t_-o-f_-p-l-a-y-e-r-s.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 50 |

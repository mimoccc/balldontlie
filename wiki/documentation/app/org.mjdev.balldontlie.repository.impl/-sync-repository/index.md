//[app](../../../index.md)/[org.mjdev.balldontlie.repository.impl](../index.md)/[SyncRepository](index.md)

# SyncRepository

[androidJvm]\
class [SyncRepository](index.md)@Injectconstructor(var dao: [DAO](../../org.mjdev.balldontlie.database/-d-a-o/index.md)) : [IRepository](../../org.mjdev.balldontlie.repository.def/-i-repository/index.md)

## Constructors

| | |
|---|---|
| [SyncRepository](-sync-repository.md) | [androidJvm]<br>@Inject<br>constructor(dao: [DAO](../../org.mjdev.balldontlie.database/-d-a-o/index.md)) |

## Functions

| Name | Summary |
|---|---|
| [getPlayer](get-player.md) | [androidJvm]<br>open suspend override fun [getPlayer](get-player.md)(id: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): [Result](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-result/index.html)&lt;[Player](../../org.mjdev.balldontlie.model/-player/index.md)&gt; |
| [getPlayers](get-players.md) | [androidJvm]<br>open suspend override fun [getPlayers](get-players.md)(page: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), perPage: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): [Result](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-result/index.html)&lt;[Players](../../org.mjdev.balldontlie.model/-players/index.md)&gt; |

## Properties

| Name | Summary |
|---|---|
| [dao](dao.md) | [androidJvm]<br>var [dao](dao.md): [DAO](../../org.mjdev.balldontlie.database/-d-a-o/index.md) |

//[app](../../../index.md)/[org.mjdev.balldontlie.repository.impl](../index.md)/[ApiRepository](index.md)

# ApiRepository

[androidJvm]\
class [ApiRepository](index.md)@Injectconstructor(var apiService: [ApiService](../../org.mjdev.balldontlie.network/-api-service/index.md)) : [INetworkRepository](../../org.mjdev.balldontlie.repository.def/-i-network-repository/index.md)

## Constructors

| | |
|---|---|
| [ApiRepository](-api-repository.md) | [androidJvm]<br>@Inject<br>constructor(apiService: [ApiService](../../org.mjdev.balldontlie.network/-api-service/index.md)) |

## Functions

| Name | Summary |
|---|---|
| [getPlayer](get-player.md) | [androidJvm]<br>open suspend override fun [getPlayer](get-player.md)(id: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): [Result](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-result/index.html)&lt;[Player](../../org.mjdev.balldontlie.model/-player/index.md)&gt; |
| [getPlayers](get-players.md) | [androidJvm]<br>open suspend override fun [getPlayers](get-players.md)(page: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), perPage: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): [Result](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-result/index.html)&lt;[Players](../../org.mjdev.balldontlie.model/-players/index.md)&gt; |

## Properties

| Name | Summary |
|---|---|
| [apiService](api-service.md) | [androidJvm]<br>var [apiService](api-service.md): [ApiService](../../org.mjdev.balldontlie.network/-api-service/index.md) |

//[app](../../../index.md)/[org.mjdev.balldontlie.viewmodel](../index.md)/[DetailViewModel](index.md)

# DetailViewModel

[androidJvm]\
class [DetailViewModel](index.md)@Injectconstructor(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html), repository: [IRepository](../../org.mjdev.balldontlie.repository.def/-i-repository/index.md)) : [BaseViewModel](../../org.mjdev.balldontlie.base.viewmodel/-base-view-model/index.md)

## Constructors

| | |
|---|---|
| [DetailViewModel](-detail-view-model.md) | [androidJvm]<br>@Inject<br>constructor(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html), repository: [IRepository](../../org.mjdev.balldontlie.repository.def/-i-repository/index.md)) |

## Functions

| Name | Summary |
|---|---|
| [addCloseable](../-main-view-model/index.md#264516373%2FFunctions%2F-912451524) | [androidJvm]<br>open fun [addCloseable](../-main-view-model/index.md#264516373%2FFunctions%2F-912451524)(@[NonNull](https://developer.android.com/reference/kotlin/androidx/annotation/NonNull.html)p0: [Closeable](https://developer.android.com/reference/kotlin/java/io/Closeable.html)) |
| [handleError](../../org.mjdev.balldontlie.base.viewmodel/-base-view-model/handle-error.md) | [androidJvm]<br>fun [handleError](../../org.mjdev.balldontlie.base.viewmodel/-base-view-model/handle-error.md)(block: (error: [Throwable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)) |
| [player](player.md) | [androidJvm]<br>suspend fun [player](player.md)(playerId: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): [Player](../../org.mjdev.balldontlie.model/-player/index.md) |

## Properties

| Name | Summary |
|---|---|
| [error](../../org.mjdev.balldontlie.base.viewmodel/-base-view-model/error.md) | [androidJvm]<br>val [error](../../org.mjdev.balldontlie.base.viewmodel/-base-view-model/error.md): MutableStateFlow&lt;[ApiError](../../org.mjdev.balldontlie.error/-api-error/index.md)&gt; |
| [networkStatus](../../org.mjdev.balldontlie.base.viewmodel/-base-view-model/network-status.md) | [androidJvm]<br>val [networkStatus](../../org.mjdev.balldontlie.base.viewmodel/-base-view-model/network-status.md): StateFlow&lt;[NetworkStatus](../../org.mjdev.balldontlie.base.network/-network-status/index.md)&gt;<br>Network status as flow |

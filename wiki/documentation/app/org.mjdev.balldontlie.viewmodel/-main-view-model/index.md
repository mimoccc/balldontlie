//[app](../../../index.md)/[org.mjdev.balldontlie.viewmodel](../index.md)/[MainViewModel](index.md)

# MainViewModel

[androidJvm]\
class [MainViewModel](index.md)@Injectconstructor(repository: [IRepository](../../org.mjdev.balldontlie.repository.def/-i-repository/index.md)) : [BaseViewModel](../../org.mjdev.balldontlie.base.viewmodel/-base-view-model/index.md)

## Constructors

| | |
|---|---|
| [MainViewModel](-main-view-model.md) | [androidJvm]<br>@Inject<br>constructor(repository: [IRepository](../../org.mjdev.balldontlie.repository.def/-i-repository/index.md)) |

## Functions

| Name | Summary |
|---|---|
| [addCloseable](index.md#264516373%2FFunctions%2F-912451524) | [androidJvm]<br>open fun [addCloseable](index.md#264516373%2FFunctions%2F-912451524)(@[NonNull](https://developer.android.com/reference/kotlin/androidx/annotation/NonNull.html)p0: [Closeable](https://developer.android.com/reference/kotlin/java/io/Closeable.html)) |
| [handleError](../../org.mjdev.balldontlie.base.viewmodel/-base-view-model/handle-error.md) | [androidJvm]<br>fun [handleError](../../org.mjdev.balldontlie.base.viewmodel/-base-view-model/handle-error.md)(block: (error: [Throwable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)) |
| [players](players.md) | [androidJvm]<br>suspend fun [players](players.md)(page: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 0, cnt: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 50): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[Player](../../org.mjdev.balldontlie.model/-player/index.md)&gt; |

## Properties

| Name | Summary |
|---|---|
| [error](../../org.mjdev.balldontlie.base.viewmodel/-base-view-model/error.md) | [androidJvm]<br>val [error](../../org.mjdev.balldontlie.base.viewmodel/-base-view-model/error.md): MutableStateFlow&lt;[ApiError](../../org.mjdev.balldontlie.error/-api-error/index.md)&gt; |

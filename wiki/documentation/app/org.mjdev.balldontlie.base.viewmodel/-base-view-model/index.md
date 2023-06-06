//[app](../../../index.md)/[org.mjdev.balldontlie.base.viewmodel](../index.md)/[BaseViewModel](index.md)

# BaseViewModel

open class [BaseViewModel](index.md) : [ViewModel](https://developer.android.com/reference/kotlin/androidx/lifecycle/ViewModel.html)

#### Inheritors

| |
|---|
| [DetailViewModel](../../org.mjdev.balldontlie.viewmodel/-detail-view-model/index.md) |
| [MainViewModel](../../org.mjdev.balldontlie.viewmodel/-main-view-model/index.md) |

## Constructors

| | |
|---|---|
| [BaseViewModel](-base-view-model.md) | [androidJvm]<br>constructor() |

## Functions

| Name | Summary |
|---|---|
| [addCloseable](../../org.mjdev.balldontlie.viewmodel/-main-view-model/index.md#264516373%2FFunctions%2F-912451524) | [androidJvm]<br>open fun [addCloseable](../../org.mjdev.balldontlie.viewmodel/-main-view-model/index.md#264516373%2FFunctions%2F-912451524)(@[NonNull](https://developer.android.com/reference/kotlin/androidx/annotation/NonNull.html)p0: [Closeable](https://developer.android.com/reference/kotlin/java/io/Closeable.html)) |
| [handleError](handle-error.md) | [androidJvm]<br>fun [handleError](handle-error.md)(block: (error: [Throwable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)) |

## Properties

| Name | Summary |
|---|---|
| [error](error.md) | [androidJvm]<br>val [error](error.md): MutableStateFlow&lt;[ApiError](../../org.mjdev.balldontlie.error/-api-error/index.md)&gt; |

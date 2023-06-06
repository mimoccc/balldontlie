//[app](../../../index.md)/[org.mjdev.balldontlie.base.states](../index.md)/[ActivityViewState](index.md)

# ActivityViewState

[androidJvm]\
class [ActivityViewState](index.md)(title: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)? = null, loading: [LoadState](https://developer.android.com/reference/kotlin/androidx/paging/LoadState.html) = LoadState.Loading, error: [ApiError](../../org.mjdev.balldontlie.error/-api-error/index.md) = EmptyError())

## Constructors

| | |
|---|---|
| [ActivityViewState](-activity-view-state.md) | [androidJvm]<br>constructor(title: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)? = null, loading: [LoadState](https://developer.android.com/reference/kotlin/androidx/paging/LoadState.html) = LoadState.Loading, error: [ApiError](../../org.mjdev.balldontlie.error/-api-error/index.md) = EmptyError()) |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [androidJvm]<br>object [Companion](-companion/index.md) |

## Functions

| Name | Summary |
|---|---|
| [clearError](clear-error.md) | [androidJvm]<br>fun [clearError](clear-error.md)() |
| [error](error.md) | [androidJvm]<br>fun [error](error.md)(message: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html))<br>fun [error](error.md)(e: [Throwable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)) |
| [info](info.md) | [androidJvm]<br>fun [info](info.md)(message: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html))<br>fun [info](info.md)(e: [Throwable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)) |
| [setIsLoading](set-is-loading.md) | [androidJvm]<br>fun [setIsLoading](set-is-loading.md)() |
| [setIsNotLoading](set-is-not-loading.md) | [androidJvm]<br>fun [setIsNotLoading](set-is-not-loading.md)(endOfPaginationReached: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = true) |
| [setLoadingState](set-loading-state.md) | [androidJvm]<br>fun [setLoadingState](set-loading-state.md)(state: [LoadState](https://developer.android.com/reference/kotlin/androidx/paging/LoadState.html)) |
| [setTitle](set-title.md) | [androidJvm]<br>fun [setTitle](set-title.md)(title: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) |

## Properties

| Name | Summary |
|---|---|
| [errorState](error-state.md) | [androidJvm]<br>val [errorState](error-state.md): [MutableState](https://developer.android.com/reference/kotlin/androidx/compose/runtime/MutableState.html)&lt;[ApiError](../../org.mjdev.balldontlie.error/-api-error/index.md)&gt; |
| [loadingState](loading-state.md) | [androidJvm]<br>val [loadingState](loading-state.md): [MutableState](https://developer.android.com/reference/kotlin/androidx/compose/runtime/MutableState.html)&lt;[LoadState](https://developer.android.com/reference/kotlin/androidx/paging/LoadState.html)&gt; |
| [titleState](title-state.md) | [androidJvm]<br>val [titleState](title-state.md): [MutableState](https://developer.android.com/reference/kotlin/androidx/compose/runtime/MutableState.html)&lt;[Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?&gt; |

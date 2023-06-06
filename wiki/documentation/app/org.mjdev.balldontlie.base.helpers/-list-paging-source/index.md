//[app](../../../index.md)/[org.mjdev.balldontlie.base.helpers](../index.md)/[ListPagingSource](index.md)

# ListPagingSource

[androidJvm]\
class [ListPagingSource](index.md)&lt;[T](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt;(perPage: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 50, source: [SOURCE](../index.md#1428666533%2FClasslikes%2F-912451524)&lt;[T](index.md)&gt; = { _, _ -&gt; emptyList() }, maxRetryCount: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = DEFAULT_MAX_RETRY_COUNT, retryDelay: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) = DEFAULT_RETRY_DELAY) : [PagingSource](https://developer.android.com/reference/kotlin/androidx/paging/PagingSource.html)&lt;[Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), [T](index.md)&gt;

## Constructors

| | |
|---|---|
| [ListPagingSource](-list-paging-source.md) | [androidJvm]<br>constructor(perPage: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 50, source: [SOURCE](../index.md#1428666533%2FClasslikes%2F-912451524)&lt;[T](index.md)&gt; = { _, _ -&gt; emptyList() }, maxRetryCount: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = DEFAULT_MAX_RETRY_COUNT, retryDelay: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) = DEFAULT_RETRY_DELAY) |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [androidJvm]<br>object [Companion](-companion/index.md) |

## Functions

| Name | Summary |
|---|---|
| [getRefreshKey](get-refresh-key.md) | [androidJvm]<br>open override fun [getRefreshKey](get-refresh-key.md)(state: [PagingState](https://developer.android.com/reference/kotlin/androidx/paging/PagingState.html)&lt;[Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), [T](index.md)&gt;): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)? |
| [invalidate](index.md#1106667736%2FFunctions%2F-912451524) | [androidJvm]<br>fun [invalidate](index.md#1106667736%2FFunctions%2F-912451524)() |
| [load](load.md) | [androidJvm]<br>open suspend override fun [load](load.md)(params: [PagingSource.LoadParams](https://developer.android.com/reference/kotlin/androidx/paging/PagingSource.LoadParams.html)&lt;[Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)&gt;): [PagingSource.LoadResult](https://developer.android.com/reference/kotlin/androidx/paging/PagingSource.LoadResult.html)&lt;[Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), [T](index.md)&gt; |
| [registerInvalidatedCallback](index.md#-395603798%2FFunctions%2F-912451524) | [androidJvm]<br>fun [registerInvalidatedCallback](index.md#-395603798%2FFunctions%2F-912451524)(onInvalidatedCallback: () -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)) |
| [unregisterInvalidatedCallback](index.md#814983601%2FFunctions%2F-912451524) | [androidJvm]<br>fun [unregisterInvalidatedCallback](index.md#814983601%2FFunctions%2F-912451524)(onInvalidatedCallback: () -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)) |

## Properties

| Name | Summary |
|---|---|
| [invalid](index.md#-162919568%2FProperties%2F-912451524) | [androidJvm]<br>val [invalid](index.md#-162919568%2FProperties%2F-912451524): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [jumpingSupported](index.md#242546777%2FProperties%2F-912451524) | [androidJvm]<br>open val [jumpingSupported](index.md#242546777%2FProperties%2F-912451524): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [keyReuseSupported](index.md#-439827890%2FProperties%2F-912451524) | [androidJvm]<br>open val [keyReuseSupported](index.md#-439827890%2FProperties%2F-912451524): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |

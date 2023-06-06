//[app](../../index.md)/[org.mjdev.balldontlie.base.helpers](index.md)

# Package-level declarations

## Types

| Name | Summary |
|---|---|
| [Ext](-ext/index.md) | [androidJvm]<br>object [Ext](-ext/index.md) |
| [ListPagingSource](-list-paging-source/index.md) | [androidJvm]<br>class [ListPagingSource](-list-paging-source/index.md)&lt;[T](-list-paging-source/index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt;(perPage: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 50, source: [SOURCE](index.md#1428666533%2FClasslikes%2F-912451524)&lt;[T](-list-paging-source/index.md)&gt; = { _, _ -&gt; emptyList() }, maxRetryCount: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = DEFAULT_MAX_RETRY_COUNT, retryDelay: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) = DEFAULT_RETRY_DELAY) : [PagingSource](https://developer.android.com/reference/kotlin/androidx/paging/PagingSource.html)&lt;[Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), [T](-list-paging-source/index.md)&gt; |
| [PermissionsManager](-permissions-manager/index.md) | [androidJvm]<br>class [PermissionsManager](-permissions-manager/index.md)(val context: [ComposableActivity](../org.mjdev.balldontlie.base.activity/-composable-activity/index.md), val permissionsRequested: [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)&gt;? = null, val onUnGranted: [PermissionsManager](-permissions-manager/index.md).(permissions: [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)&gt;) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) = { ps -&gt;         ps.forEach { p -&gt;             Timber.e(&quot;Permission check (non-granted) : $p&quot;)         }     }, val onGranted: [PermissionsManager](-permissions-manager/index.md).(permissions: [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)&gt;) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) = { ps -&gt;         ps.forEach { p -&gt;             Timber.d(&quot;Permission check (ok) : $p&quot;)         }     }) |
| [SOURCE](index.md#1428666533%2FClasslikes%2F-912451524) | [androidJvm]<br>typealias [SOURCE](index.md#1428666533%2FClasslikes%2F-912451524)&lt;[T](index.md#1428666533%2FClasslikes%2F-912451524)&gt; = suspend (page: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), cnt: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)) -&gt; [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[T](index.md#1428666533%2FClasslikes%2F-912451524)&gt; |

## Properties

| Name | Summary |
|---|---|
| [REQUEST_CODE_OPEN_DOCUMENT_TREE](-r-e-q-u-e-s-t_-c-o-d-e_-o-p-e-n_-d-o-c-u-m-e-n-t_-t-r-e-e.md) | [androidJvm]<br>const val [REQUEST_CODE_OPEN_DOCUMENT_TREE](-r-e-q-u-e-s-t_-c-o-d-e_-o-p-e-n_-d-o-c-u-m-e-n-t_-t-r-e-e.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 124 |
| [REQUEST_CODE_PERMISSIONS](-r-e-q-u-e-s-t_-c-o-d-e_-p-e-r-m-i-s-s-i-o-n-s.md) | [androidJvm]<br>const val [REQUEST_CODE_PERMISSIONS](-r-e-q-u-e-s-t_-c-o-d-e_-p-e-r-m-i-s-s-i-o-n-s.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 125 |

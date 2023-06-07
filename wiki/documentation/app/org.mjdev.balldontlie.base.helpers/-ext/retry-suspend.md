//[app](../../../index.md)/[org.mjdev.balldontlie.base.helpers](../index.md)/[Ext](index.md)/[retrySuspend](retry-suspend.md)

# retrySuspend

[androidJvm]\
suspend fun &lt;[T](retry-suspend.md)&gt; [retrySuspend](retry-suspend.md)(retryDelay: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) = ListPagingSource.DEFAULT_RETRY_DELAY, maxRetryCount: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = ListPagingSource.DEFAULT_MAX_RETRY_COUNT, condition: [T](retry-suspend.md).() -&gt; [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html), block: suspend () -&gt; [T](retry-suspend.md)): [T](retry-suspend.md)

Function made calls until retry count is not 0. As a result it give block call result or Unit, if retry count is 0.

#### Return

[T](retry-suspend.md)

#### Parameters

androidJvm

| | |
|---|---|
| retryDelay | Retry delay |
| maxRetryCount | Max retry count |
| condition | Condition |
| block | code that is run [maxRetryCount](retry-suspend.md) times, delayed     [retryDelay](retry-suspend.md) ms, until condition reached true. |
| T | T return value |

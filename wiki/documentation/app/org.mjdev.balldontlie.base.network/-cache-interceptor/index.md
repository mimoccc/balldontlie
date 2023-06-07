//[app](../../../index.md)/[org.mjdev.balldontlie.base.network](../index.md)/[CacheInterceptor](index.md)

# CacheInterceptor

[androidJvm]\
class [CacheInterceptor](index.md)(maxAge: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 1, timeUnit: [TimeUnit](https://developer.android.com/reference/kotlin/java/util/concurrent/TimeUnit.html) = TimeUnit.HOURS) : Interceptor

Cache interceptor. Made to cache result from internet. Basically for an one hour, to avoid multiple calls.

## Constructors

| | |
|---|---|
| [CacheInterceptor](-cache-interceptor.md) | [androidJvm]<br>constructor(maxAge: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 1, timeUnit: [TimeUnit](https://developer.android.com/reference/kotlin/java/util/concurrent/TimeUnit.html) = TimeUnit.HOURS)<br>Create [CacheInterceptor](index.md) |

## Functions

| Name | Summary |
|---|---|
| [intercept](intercept.md) | [androidJvm]<br>open override fun [intercept](intercept.md)(chain: Interceptor.Chain): Response<br>Intercept network calls. |

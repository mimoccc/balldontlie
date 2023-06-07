//[app](../../index.md)/[org.mjdev.balldontlie.error](index.md)

# Package-level declarations

## Types

| Name | Summary |
|---|---|
| [ApiError](-api-error/index.md) | [androidJvm]<br>open class [ApiError](-api-error/index.md)(val message: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;Unknown error.&quot;, val title: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;Error&quot;, val t: [Throwable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)? = null) : [Exception](https://developer.android.com/reference/kotlin/java/lang/Exception.html), [Parcelable](https://developer.android.com/reference/kotlin/android/os/Parcelable.html) |
| [EmptyError](-empty-error/index.md) | [androidJvm]<br>class [EmptyError](-empty-error/index.md) : [ApiError](-api-error/index.md) |
| [HttpError](-http-error/index.md) | [androidJvm]<br>enum [HttpError](-http-error/index.md) : [Enum](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-enum/index.html)&lt;[HttpError](-http-error/index.md)&gt; |
| [Info](-info/index.md) | [androidJvm]<br>class [Info](-info/index.md) : [ApiError](-api-error/index.md) |

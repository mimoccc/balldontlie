//[app](../../../index.md)/[org.mjdev.balldontlie.error](../index.md)/[ApiError](index.md)

# ApiError

open class [ApiError](index.md)(val message: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;Unknown error.&quot;, val title: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;Error&quot;, val t: [Throwable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)? = null) : [Exception](https://developer.android.com/reference/kotlin/java/lang/Exception.html), [Parcelable](https://developer.android.com/reference/kotlin/android/os/Parcelable.html)

#### Inheritors

| |
|---|
| [EmptyError](../-empty-error/index.md) |
| [Info](../-info/index.md) |

## Constructors

| | |
|---|---|
| [ApiError](-api-error.md) | [androidJvm]<br>constructor(response: Response&lt;*&gt;)constructor(e: [Throwable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html))constructor(message: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;Unknown error.&quot;, title: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;Error&quot;, t: [Throwable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)? = null) |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [androidJvm]<br>object [Companion](-companion/index.md) |

## Functions

| Name | Summary |
|---|---|
| [addSuppressed](../-info/index.md#282858770%2FFunctions%2F-912451524) | [androidJvm]<br>fun [addSuppressed](../-info/index.md#282858770%2FFunctions%2F-912451524)(p0: [Throwable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)) |
| [asApiError](-companion/as-api-error.md) | [androidJvm]<br>fun [Throwable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html).[asApiError](-companion/as-api-error.md)(): [ApiError](index.md) |
| [describeContents](../-info/index.md#-1578325224%2FFunctions%2F-912451524) | [androidJvm]<br>abstract fun [describeContents](../-info/index.md#-1578325224%2FFunctions%2F-912451524)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [fillInStackTrace](../-info/index.md#-1102069925%2FFunctions%2F-912451524) | [androidJvm]<br>open fun [fillInStackTrace](../-info/index.md#-1102069925%2FFunctions%2F-912451524)(): [Throwable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html) |
| [getLocalizedMessage](../-info/index.md#1043865560%2FFunctions%2F-912451524) | [androidJvm]<br>open fun [getLocalizedMessage](../-info/index.md#1043865560%2FFunctions%2F-912451524)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [getStackTrace](../-info/index.md#2050903719%2FFunctions%2F-912451524) | [androidJvm]<br>open fun [getStackTrace](../-info/index.md#2050903719%2FFunctions%2F-912451524)(): [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)&lt;[StackTraceElement](https://developer.android.com/reference/kotlin/java/lang/StackTraceElement.html)&gt; |
| [getSuppressed](../-info/index.md#672492560%2FFunctions%2F-912451524) | [androidJvm]<br>fun [getSuppressed](../-info/index.md#672492560%2FFunctions%2F-912451524)(): [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)&lt;[Throwable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)&gt; |
| [initCause](../-info/index.md#-418225042%2FFunctions%2F-912451524) | [androidJvm]<br>open fun [initCause](../-info/index.md#-418225042%2FFunctions%2F-912451524)(p0: [Throwable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)): [Throwable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html) |
| [printStackTrace](../-info/index.md#-1769529168%2FFunctions%2F-912451524) | [androidJvm]<br>open fun [printStackTrace](../-info/index.md#-1769529168%2FFunctions%2F-912451524)()<br>open fun [printStackTrace](../-info/index.md#1841853697%2FFunctions%2F-912451524)(p0: [PrintStream](https://developer.android.com/reference/kotlin/java/io/PrintStream.html))<br>open fun [printStackTrace](../-info/index.md#1175535278%2FFunctions%2F-912451524)(p0: [PrintWriter](https://developer.android.com/reference/kotlin/java/io/PrintWriter.html)) |
| [setStackTrace](../-info/index.md#2135801318%2FFunctions%2F-912451524) | [androidJvm]<br>open fun [setStackTrace](../-info/index.md#2135801318%2FFunctions%2F-912451524)(p0: [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)&lt;[StackTraceElement](https://developer.android.com/reference/kotlin/java/lang/StackTraceElement.html)&gt;) |
| [writeToParcel](../-info/index.md#-1754457655%2FFunctions%2F-912451524) | [androidJvm]<br>abstract fun [writeToParcel](../-info/index.md#-1754457655%2FFunctions%2F-912451524)(p0: [Parcel](https://developer.android.com/reference/kotlin/android/os/Parcel.html), p1: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)) |

## Properties

| Name | Summary |
|---|---|
| [backgroundColor](background-color.md) | [androidJvm]<br>open var [backgroundColor](background-color.md): [Color](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Color.html) |
| [cause](../-info/index.md#-654012527%2FProperties%2F-912451524) | [androidJvm]<br>open val [cause](../-info/index.md#-654012527%2FProperties%2F-912451524): [Throwable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)? |
| [fileName](file-name.md) | [androidJvm]<br>val [fileName](file-name.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [lineNumber](line-number.md) | [androidJvm]<br>val [lineNumber](line-number.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [message](message.md) | [androidJvm]<br>open override val [message](message.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [t](t.md) | [androidJvm]<br>open val [t](t.md): [Throwable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)? = null |
| [textColor](text-color.md) | [androidJvm]<br>open var [textColor](text-color.md): [Color](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Color.html) |
| [title](title.md) | [androidJvm]<br>open val [title](title.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |

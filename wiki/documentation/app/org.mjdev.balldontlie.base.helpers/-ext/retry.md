//[app](../../../index.md)/[org.mjdev.balldontlie.base.helpers](../index.md)/[Ext](index.md)/[retry](retry.md)

# retry

[androidJvm]\
fun &lt;[T](retry.md)&gt; [retry](retry.md)(retryCnt: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 8, retryDelay: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) = 500, looper: [Looper](https://developer.android.com/reference/kotlin/android/os/Looper.html) = Looper.myLooper() ?: Looper.getMainLooper(), onError: (error: [Throwable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) = { e -&gt; throw (e) }, block: () -&gt; [T](retry.md))

//[app](../../../index.md)/[org.mjdev.balldontlie.base.helpers](../index.md)/[PermissionsManager](index.md)/[PermissionsManager](-permissions-manager.md)

# PermissionsManager

[androidJvm]\
constructor(context: [ComposableActivity](../../org.mjdev.balldontlie.base.activity/-composable-activity/index.md), permissionsRequested: [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)&gt;? = null, onUnGranted: [PermissionsManager](index.md).(permissions: [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)&gt;) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) = { ps -&gt;
        ps.forEach { p -&gt;
            Timber.e(&quot;Permission check (non-granted) : $p&quot;)
        }
    }, onGranted: [PermissionsManager](index.md).(permissions: [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)&gt;) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) = { ps -&gt;
        ps.forEach { p -&gt;
            Timber.d(&quot;Permission check (ok) : $p&quot;)
        }
    })

//[app](../../../index.md)/[org.mjdev.balldontlie.base.helpers](../index.md)/[PermissionsManager](index.md)

# PermissionsManager

[androidJvm]\
class [PermissionsManager](index.md)(val context: [ComposableActivity](../../org.mjdev.balldontlie.base.activity/-composable-activity/index.md), val permissionsRequested: [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)&gt;? = null, val onUnGranted: [PermissionsManager](index.md).(permissions: [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)&gt;) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) = { ps -&gt;
        ps.forEach { p -&gt;
            Timber.e(&quot;Permission check (non-granted) : $p&quot;)
        }
    }, val onGranted: [PermissionsManager](index.md).(permissions: [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)&gt;) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) = { ps -&gt;
        ps.forEach { p -&gt;
            Timber.d(&quot;Permission check (ok) : $p&quot;)
        }
    })

## Constructors

| | |
|---|---|
| [PermissionsManager](-permissions-manager.md) | [androidJvm]<br>constructor(context: [ComposableActivity](../../org.mjdev.balldontlie.base.activity/-composable-activity/index.md), permissionsRequested: [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)&gt;? = null, onUnGranted: [PermissionsManager](index.md).(permissions: [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)&gt;) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) = { ps -&gt;         ps.forEach { p -&gt;             Timber.e(&quot;Permission check (non-granted) : $p&quot;)         }     }, onGranted: [PermissionsManager](index.md).(permissions: [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)&gt;) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) = { ps -&gt;         ps.forEach { p -&gt;             Timber.d(&quot;Permission check (ok) : $p&quot;)         }     }) |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [androidJvm]<br>object [Companion](-companion/index.md) |

## Functions

| Name | Summary |
|---|---|
| [checkPermissions](check-permissions.md) | [androidJvm]<br>fun [checkPermissions](check-permissions.md)() |
| [requestPermission](request-permission.md) | [androidJvm]<br>fun [requestPermission](request-permission.md)(permission: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) |
| [requestPermissions](request-permissions.md) | [androidJvm]<br>fun [requestPermissions](request-permissions.md)(vararg permission: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) |

## Properties

| Name | Summary |
|---|---|
| [context](context.md) | [androidJvm]<br>val [context](context.md): [ComposableActivity](../../org.mjdev.balldontlie.base.activity/-composable-activity/index.md) |
| [onGranted](on-granted.md) | [androidJvm]<br>val [onGranted](on-granted.md): [PermissionsManager](index.md).(permissions: [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)&gt;) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onUnGranted](on-un-granted.md) | [androidJvm]<br>val [onUnGranted](on-un-granted.md): [PermissionsManager](index.md).(permissions: [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)&gt;) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [permissions](permissions.md) | [androidJvm]<br>val [permissions](permissions.md): [MutableList](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)&gt; |
| [permissionsRequested](permissions-requested.md) | [androidJvm]<br>val [permissionsRequested](permissions-requested.md): [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)&gt;? = null |

//[app](../../../../index.md)/[org.mjdev.balldontlie.base.helpers](../../index.md)/[PermissionsManager](../index.md)/[Companion](index.md)

# Companion

[androidJvm]\
object [Companion](index.md)

## Functions

| Name | Summary |
|---|---|
| [permissionsManager](permissions-manager.md) | [androidJvm]<br>@[MainThread](https://developer.android.com/reference/kotlin/androidx/annotation/MainThread.html)<br>fun [ComponentActivity](https://developer.android.com/reference/kotlin/androidx/activity/ComponentActivity.html).[permissionsManager](permissions-manager.md)(onPermissionsGranted: [PermissionsManager](../index.md).(permissions: [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)&gt;) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) = {}, onPermissionsUnGranted: [PermissionsManager](../index.md).(permissions: [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)&gt;) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) = {}): [PermissionsManager](../index.md) |
| [rememberPermissionManager](remember-permission-manager.md) | [androidJvm]<br>@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)<br>fun [rememberPermissionManager](remember-permission-manager.md)(onNonGrantedPermissions: (permissions: [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)&gt;) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) = {}): [PermissionsManager](../index.md) |

## Properties

| Name | Summary |
|---|---|
| [manifestPermissions](manifest-permissions.md) | [androidJvm]<br>val [Context](https://developer.android.com/reference/kotlin/android/content/Context.html).[manifestPermissions](manifest-permissions.md): [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)&gt; |

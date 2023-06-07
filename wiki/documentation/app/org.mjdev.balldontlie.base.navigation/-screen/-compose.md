//[app](../../../index.md)/[org.mjdev.balldontlie.base.navigation](../index.md)/[Screen](index.md)/[Compose](-compose.md)

# Compose

[androidJvm]\

@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)

@[CallSuper](https://developer.android.com/reference/kotlin/androidx/annotation/CallSuper.html)

open fun [Compose](-compose.md)()

Compose function.

Helper function to preview without parameters as preview of compose needed.

#### Return

[androidJvm]\

@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)

open fun [Compose](-compose.md)(navController: [NavHostController](https://developer.android.com/reference/kotlin/androidx/navigation/NavHostController.html)?, backStackEntry: [NavBackStackEntry](https://developer.android.com/reference/kotlin/androidx/navigation/NavBackStackEntry.html)?, menuItems: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[MenuItem](../-menu-item/index.md)&gt;)

Compose function for compose screen. This should be only a method overriden in super classes.

#### Parameters

androidJvm

| | |
|---|---|
| navController | Nav controller |
| backStackEntry | Back stack entry |
| menuItems | Menu items |

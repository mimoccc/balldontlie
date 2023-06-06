//[app](../../../index.md)/[org.mjdev.balldontlie.base.navigation](../index.md)/[Screen](index.md)

# Screen

open class [Screen](index.md)

#### Inheritors

| |
|---|
| [AboutScreen](../../org.mjdev.balldontlie.ui.screens/-about-screen/index.md) |
| [DetailScreen](../../org.mjdev.balldontlie.ui.screens/-detail-screen/index.md) |
| [MainScreen](../../org.mjdev.balldontlie.ui.screens/-main-screen/index.md) |

## Constructors

| | |
|---|---|
| [Screen](-screen.md) | [androidJvm]<br>constructor() |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [androidJvm]<br>object [Companion](-companion/index.md) |

## Functions

| Name | Summary |
|---|---|
| [Compose](-compose.md) | [androidJvm]<br>@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)<br>@[CallSuper](https://developer.android.com/reference/kotlin/androidx/annotation/CallSuper.html)<br>open fun [Compose](-compose.md)()<br>@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)<br>open fun [Compose](-compose.md)(navController: [NavHostController](https://developer.android.com/reference/kotlin/androidx/navigation/NavHostController.html)?, backStackEntry: [NavBackStackEntry](https://developer.android.com/reference/kotlin/androidx/navigation/NavBackStackEntry.html)?, menuItems: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[MenuItem](../-menu-item/index.md)&gt;) |

## Properties

| Name | Summary |
|---|---|
| [args](args.md) | [androidJvm]<br>open val [args](args.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[NamedNavArgument](https://developer.android.com/reference/kotlin/androidx/navigation/NamedNavArgument.html)&gt; |
| [completeRoute](complete-route.md) | [androidJvm]<br>val [completeRoute](complete-route.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [menuIcon](menu-icon.md) | [androidJvm]<br>open val [menuIcon](menu-icon.md): [ImageVector](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/vector/ImageVector.html)? = null |
| [menuItem](menu-item.md) | [androidJvm]<br>val [menuItem](menu-item.md): [MenuItem](../-menu-item/index.md)? |
| [menuResId](menu-res-id.md) | [androidJvm]<br>open val [menuResId](menu-res-id.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [titleResId](title-res-id.md) | [androidJvm]<br>open val [titleResId](title-res-id.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |

//[app](../../../index.md)/[org.mjdev.balldontlie.base.helpers](../index.md)/[Ext](index.md)/[screen](screen.md)

# screen

[androidJvm]\
fun &lt;[T](screen.md) : [Screen](../../org.mjdev.balldontlie.base.navigation/-screen/index.md)&gt; [NavGraphBuilderEx](../../org.mjdev.balldontlie.base.navigation/-nav-graph-builder-ex/index.md).[screen](screen.md)(route: [T](screen.md), isHomeScreen: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false)

Custom function to generate screen in nav graph.

#### Receiver

[NavGraphBuilderEx](../../org.mjdev.balldontlie.base.navigation/-nav-graph-builder-ex/index.md)

#### Parameters

androidJvm

| | |
|---|---|
| route | Route route expected |
| isHomeScreen | Is home screen, indicates that this screen will be used as home screen. Should be used once, or in case that is defined multiple times, the last one is used as home screen. |
| T | T Screen object generated for route. |

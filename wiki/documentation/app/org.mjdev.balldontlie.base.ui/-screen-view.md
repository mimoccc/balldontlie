//[app](../../index.md)/[org.mjdev.balldontlie.base.ui](index.md)/[ScreenView](-screen-view.md)

# ScreenView

[androidJvm]\

@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)

fun [ScreenView](-screen-view.md)(navController: [NavHostController](https://developer.android.com/reference/kotlin/androidx/navigation/NavHostController.html)? = null, navigationIconMain: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)? = Icons.Filled.Menu, navigationIconBack: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)? = Icons.Filled.ArrowBack, actions: @[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)[RowScope](https://developer.android.com/reference/kotlin/androidx/compose/foundation/layout/RowScope.html).() -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) = {}, title: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)? = previewData { R.string.app_name }, menuItems: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[MenuItem](../org.mjdev.balldontlie.base.navigation/-menu-item/index.md)&gt; = listOf(), content: @[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)(state: [ActivityViewState](../org.mjdev.balldontlie.base.states/-activity-view-state/index.md), padding: [PaddingValues](https://developer.android.com/reference/kotlin/androidx/compose/foundation/layout/PaddingValues.html)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) = { state, padding -&gt; })

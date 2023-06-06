//[app](../../index.md)/[org.mjdev.balldontlie.ui.components.players](index.md)/[PlayersList](-players-list.md)

# PlayersList

[androidJvm]\

@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)

fun [PlayersList](-players-list.md)(modifier: [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html) = previewData(Modifier) { Modifier.fillMaxSize() }, perPage: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 25, source: [SOURCE](../org.mjdev.balldontlie.base.helpers/index.md#1428666533%2FClasslikes%2F-912451524)&lt;[Player](../org.mjdev.balldontlie.model/-player/index.md)&gt; = previewSource(Player(1), Player(2)), loadStateHandler: (state: [LoadState](https://developer.android.com/reference/kotlin/androidx/paging/LoadState.html)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) = {}, onItemClick: (data: [Player](../org.mjdev.balldontlie.model/-player/index.md)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) = {})

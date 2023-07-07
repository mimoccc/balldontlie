//[app](../../index.md)/[org.mjdev.balldontlie.base.ui](index.md)/[PagingList](-paging-list.md)

# PagingList

[androidJvm]\

@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)

fun &lt;[T](-paging-list.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt; [PagingList](-paging-list.md)(modifier: [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html) = previewData(Modifier) { Modifier.fillMaxSize() }, verticalArrangement: [Arrangement.HorizontalOrVertical](https://developer.android.com/reference/kotlin/androidx/compose/foundation/layout/Arrangement.HorizontalOrVertical.html) = Arrangement.spacedBy(8.dp), perPage: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 50, source: [SOURCE](../org.mjdev.balldontlie.base.helpers/index.md#1428666533%2FClasslikes%2F-912451524)&lt;[T](-paging-list.md)&gt; = { _, _ -&gt; emptyList() }, loadStateHandler: (state: [LoadState](https://developer.android.com/reference/kotlin/androidx/paging/LoadState.html)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) = {}, onItemClick: (data: [T](-paging-list.md)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) = { _ -&gt; }, emptyContent: @[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)() -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) = {
        Text(text = &quot;Empty list&quot;)
    }, itemBlock: @[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)(idx: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), item: [T](-paging-list.md), onItemClick: (data: [T](-paging-list.md)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) = { _, _, _ -&gt; })

//[app](../../../index.md)/[org.mjdev.balldontlie.base.helpers](../index.md)/[Ext](index.md)/[previewData](preview-data.md)

# previewData

[androidJvm]\

@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)

fun &lt;[T](preview-data.md)&gt; [previewData](preview-data.md)(block: () -&gt; [T](preview-data.md)): [T](preview-data.md)?

Preview data. Helper function for previews in edit mode. It runs function in block and return is given to a composable function. Or it returns null if in released app.

#### Return

[T](preview-data.md) result or null

#### Parameters

androidJvm

| | |
|---|---|
| block | code to get result from |
| T | T type of result |

[androidJvm]\

@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)

fun &lt;[T](preview-data.md)&gt; [previewData](preview-data.md)(defaultValue: [T](preview-data.md), block: () -&gt; [T](preview-data.md)): [T](preview-data.md)

Preview data. Helper function for previews in edit mode. It runs function in block and return is given to a composable function. Or it returns [defaultValue](preview-data.md) if in released app.

#### Return

[T](preview-data.md) result or [defaultValue](preview-data.md)

#### Parameters

androidJvm

| | |
|---|---|
| defaultValue | Default value |
| block | code to get result from |
| T | T type of result |

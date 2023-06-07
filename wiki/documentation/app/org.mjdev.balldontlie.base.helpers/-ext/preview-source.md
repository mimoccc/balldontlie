//[app](../../../index.md)/[org.mjdev.balldontlie.base.helpers](../index.md)/[Ext](index.md)/[previewSource](preview-source.md)

# previewSource

[androidJvm]\

@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)

fun &lt;[T](preview-source.md)&gt; [previewSource](preview-source.md)(vararg data: [T](preview-source.md)): [SOURCE](../index.md#1428666533%2FClasslikes%2F-912451524)&lt;[T](preview-source.md)&gt;

Helper function for previews in edit mode. It runs data generated from variable params and return is given to a composable function. Or it returns empty list if in released app.

#### Return

[SOURCE](../index.md#1428666533%2FClasslikes%2F-912451524) source function as an result

#### Parameters

androidJvm

| | |
|---|---|
| data | Data |
| T | T type of result |

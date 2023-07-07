//[app](../../../index.md)/[org.mjdev.balldontlie.base.helpers](../index.md)/[OverlayImagePainter](index.md)

# OverlayImagePainter

[androidJvm]\
class [OverlayImagePainter](index.md)(image: [ImageBitmap](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/ImageBitmap.html), imageOverlay: [ImageBitmap](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/ImageBitmap.html), srcOffset: [IntOffset](https://developer.android.com/reference/kotlin/androidx/compose/ui/unit/IntOffset.html) = IntOffset.Zero, srcSize: [IntSize](https://developer.android.com/reference/kotlin/androidx/compose/ui/unit/IntSize.html) = IntSize(image.width, image.height), overlaySize: [IntSize](https://developer.android.com/reference/kotlin/androidx/compose/ui/unit/IntSize.html) = IntSize(imageOverlay.width, imageOverlay.height)) : [Painter](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/painter/Painter.html)

## Constructors

| | |
|---|---|
| [OverlayImagePainter](-overlay-image-painter.md) | [androidJvm]<br>constructor(image: [ImageBitmap](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/ImageBitmap.html), imageOverlay: [ImageBitmap](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/ImageBitmap.html), srcOffset: [IntOffset](https://developer.android.com/reference/kotlin/androidx/compose/ui/unit/IntOffset.html) = IntOffset.Zero, srcSize: [IntSize](https://developer.android.com/reference/kotlin/androidx/compose/ui/unit/IntSize.html) = IntSize(image.width, image.height), overlaySize: [IntSize](https://developer.android.com/reference/kotlin/androidx/compose/ui/unit/IntSize.html) = IntSize(imageOverlay.width, imageOverlay.height)) |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [androidJvm]<br>object [Companion](-companion/index.md) |

## Functions

| Name | Summary |
|---|---|
| [draw](index.md#31481078%2FExtensions%2F-912451524) | [androidJvm]<br>fun [DrawScope](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/drawscope/DrawScope.html).[draw](index.md#31481078%2FExtensions%2F-912451524)(size: [Size](https://developer.android.com/reference/kotlin/androidx/compose/ui/geometry/Size.html), alpha: [Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html), colorFilter: [ColorFilter](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/ColorFilter.html)?) |

## Properties

| Name | Summary |
|---|---|
| [intrinsicSize](intrinsic-size.md) | [androidJvm]<br>open override val [intrinsicSize](intrinsic-size.md): [Size](https://developer.android.com/reference/kotlin/androidx/compose/ui/geometry/Size.html)<br>Return the dimension of the underlying [ImageBitmap](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/ImageBitmap.html) as it's intrinsic width and height |

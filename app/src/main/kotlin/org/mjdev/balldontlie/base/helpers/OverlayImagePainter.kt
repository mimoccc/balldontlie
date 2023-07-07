package org.mjdev.balldontlie.base.helpers

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.toSize
import org.mjdev.balldontlie.R
import org.mjdev.balldontlie.base.helpers.OverlayImagePainter.Companion.imageResource
import org.mjdev.balldontlie.base.helpers.OverlayImagePainter.Companion.rememberOvOverlayImagePainter
import kotlin.math.roundToInt

class OverlayImagePainter constructor(
    private val image: ImageBitmap,
    private val imageOverlay: ImageBitmap,
    private val srcOffset: IntOffset = IntOffset.Zero,
    private val srcSize: IntSize = IntSize(image.width, image.height),
    private val overlaySize: IntSize = IntSize(imageOverlay.width, imageOverlay.height)
) : Painter() {

    private val size: IntSize = validateSize(srcOffset, srcSize)

    override fun DrawScope.onDraw() {
        // draw the first image without any blend mode
        drawImage(
            image,
            srcOffset,
            srcSize,
            dstSize = IntSize(
                this@onDraw.size.width.roundToInt(),
                this@onDraw.size.height.roundToInt()
            )
        )
        // draw the second image with an Overlay blend mode to blend the two together
        drawImage(
            imageOverlay,
            srcOffset,
            overlaySize,
            dstSize = IntSize(
                this@onDraw.size.width.roundToInt(),
                this@onDraw.size.height.roundToInt()
            ),
            blendMode = BlendMode.Overlay
        )
    }

    /**
     * Return the dimension of the underlying [ImageBitmap] as it's intrinsic width and height
     */
    override val intrinsicSize: Size get() = size.toSize()

    private fun validateSize(srcOffset: IntOffset, srcSize: IntSize): IntSize {
        require(
            srcOffset.x >= 0 &&
                    srcOffset.y >= 0 &&
                    srcSize.width >= 0 &&
                    srcSize.height >= 0 &&
                    srcSize.width <= image.width &&
                    srcSize.height <= image.height
        )
        return srcSize
    }

    companion object {

        @Composable
        fun rememberOvOverlayImagePainter(
            mainImage: ImageBitmap,
            overlay: ImageBitmap
        ) = remember {
            OverlayImagePainter(mainImage, overlay)
        }

        @Composable
        fun imageResource(@DrawableRes id: Int) = ImageBitmap.imageResource(id = id)

    }

}

@Preview
@Composable
fun OverlayImage() {
    val rainbowImage = imageResource(id = R.drawable.person)
    val dogImage = imageResource(id = R.drawable.milanj)
    val customPainter = rememberOvOverlayImagePainter(dogImage, rainbowImage)
    Image(
        painter = customPainter,
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier.wrapContentSize()
    )
}
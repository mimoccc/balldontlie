package org.mjdev.moneta.base.ui

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.DefaultAlpha
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import org.mjdev.moneta.R
import org.mjdev.moneta.base.annotations.NightPreview
import org.mjdev.moneta.base.helpers.Ext.asImageBitmap
import org.mjdev.moneta.base.helpers.Ext.previewData
import java.lang.RuntimeException
import java.net.URL

@SuppressLint("ModifierParameter")
@NightPreview
@Composable
fun ImageAny(
    modifier: Modifier = previewData(Modifier) { Modifier.size(64.dp) },
    src: Any? = previewData { R.drawable.milanj },
    contentDescription: String? = null,
    alignment: Alignment = Alignment.Center,
    contentScale: ContentScale = ContentScale.Fit,
    alpha: Float = DefaultAlpha,
    colorFilter: ColorFilter? = null
) = BoxWithConstraints(
    modifier = modifier
) {
    val width = constraints.minWidth
    val height = constraints.minHeight
    when (src) {

        null -> Image(
            ColorDrawable(0).asImageBitmap(width, height),
            contentDescription,
            modifier,
            alignment,
            contentScale,
            alpha,
            colorFilter
        )

        is Bitmap -> Image(
            src.asImageBitmap(),
            contentDescription,
            modifier,
            alignment,
            contentScale,
            alpha,
            colorFilter
        )

        is ImageBitmap -> Image(
            src,
            contentDescription,
            modifier,
            alignment,
            contentScale,
            alpha,
            colorFilter
        )

        is Drawable -> Image(
            src.asImageBitmap(width, height),
            contentDescription,
            modifier,
            alignment,
            contentScale,
            alpha,
            colorFilter
        )

        is Int -> Image(
            painterResource(src),
            contentDescription,
            modifier,
            alignment,
            contentScale,
            alpha,
            colorFilter
        )

        is URL -> Image(
            glideResource(src),
            contentDescription,
            modifier,
            alignment,
            contentScale,
            alpha,
            colorFilter
        )

        is Uri -> Image(
            glideResource(src),
            contentDescription,
            modifier,
            alignment,
            contentScale,
            alpha,
            colorFilter
        )

        is String -> Image(
            glideResource(src),
            contentDescription,
            modifier,
            alignment,
            contentScale,
            alpha,
            colorFilter
        )

        is ImageVector -> Image(
            src,
            contentDescription,
            modifier,
            alignment,
            contentScale,
            alpha,
            colorFilter
        )

        else -> throw (RuntimeException("Unknown image format."))
    }
}

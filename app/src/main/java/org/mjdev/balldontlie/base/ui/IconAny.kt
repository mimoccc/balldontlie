package org.mjdev.balldontlie.base.ui

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.net.Uri
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import org.mjdev.balldontlie.base.annotations.DayPreview
import org.mjdev.balldontlie.base.helpers.Ext.asImageBitmap
import org.mjdev.balldontlie.base.helpers.Ext.previewData
import java.lang.RuntimeException
import java.net.URL

@SuppressLint("ModifierParameter")
@DayPreview
@Composable
fun IconAny(
    modifier: Modifier = previewData(Modifier) { Modifier.size(64.dp) },
    src: Any? = previewData { Icons.Default.Menu },
    contentDescription: String? = null,
    tint: Color = LocalContentColor.current
) = BoxWithConstraints(
    modifier = modifier
) {
    val width = constraints.minWidth
    val height = constraints.minHeight
    when (src) {
        null -> Icon(
            ColorDrawable(0).asImageBitmap(width, height),
            contentDescription,
            modifier,
            tint
        )

        is Bitmap -> Icon(src.asImageBitmap(), contentDescription, modifier, tint)

        is ImageBitmap -> Icon(src, contentDescription, modifier, tint)

        is Drawable -> Icon(src.asImageBitmap(width, height), contentDescription, modifier, tint)

        is Int -> Icon(painterResource(src), contentDescription, modifier, tint)

        is Color -> Icon(
            ColorDrawable(0).asImageBitmap(width, height),
            contentDescription,
            modifier,
            tint
        )

        is URL -> Icon(
            glideResource(
                src = src,
                width = width,
                height = height
            ), contentDescription, modifier, tint
        )

        is Uri -> Icon(
            glideResource(
                src = src,
                width = width,
                height = height
            ), contentDescription, modifier, tint
        )

        is String -> Icon(
            glideResource(
                src = src,
                width = width,
                height = height
            ), contentDescription, modifier, tint
        )

        is ImageVector -> Icon(src, contentDescription, modifier, tint)

        else -> throw (RuntimeException("Unknown image format."))
    }
}


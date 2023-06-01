package org.mjdev.balldontlie.base.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.DefaultAlpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import org.mjdev.balldontlie.R
import org.mjdev.balldontlie.base.annotations.NightPreview
import org.mjdev.balldontlie.base.helpers.Ext.previewData

@SuppressLint("ModifierParameter")
@NightPreview
@Composable
fun GlideImageView(
    modifier: Modifier = previewData(Modifier) { Modifier.size(64.dp) },
    src: Any? = previewData {
        // glide need socket, unsupported in preview, as example simple access to drawables
        R.drawable.milanj
    },
    contentDescription: String? = null,
    alignment: Alignment = Alignment.Center,
    contentScale: ContentScale = ContentScale.Fit,
    alpha: Float = DefaultAlpha,
    colorFilter: ColorFilter? = null,
    placeHolder: Int? = null
) = BoxWithConstraints {
    val width = constraints.minWidth
    val height = constraints.minHeight
    Image(
        glideResource(src, placeHolder, width, height),
        contentDescription,
        modifier,
        alignment,
        contentScale,
        alpha,
        colorFilter
    )
}
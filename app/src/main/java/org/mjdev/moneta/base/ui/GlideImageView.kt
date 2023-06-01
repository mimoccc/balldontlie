package org.mjdev.moneta.base.ui

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
import org.mjdev.moneta.base.annotations.NightPreview
import org.mjdev.moneta.base.helpers.Ext

// todo glide module
@Suppress("SpellCheckingInspection")
@SuppressLint("ModifierParameter")
@NightPreview
@Composable
fun GlideImageView(
    modifier: Modifier = Ext.previewData(Modifier) { Modifier.size(64.dp) },
    src: Any? = Ext.previewData { "https://duckduckgo.com/assets/onboarding/bathroomguy/teaser-2@2x.png" },
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
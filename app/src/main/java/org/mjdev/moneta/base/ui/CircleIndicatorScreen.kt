package org.mjdev.moneta.base.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import org.mjdev.moneta.base.annotations.NightPreview

@NightPreview
@Composable
fun CircleIndicatorScreen(
    modifier: Modifier = Modifier,
    backgroundColor: Color = Color.White,
    alpha: Float = 0.5f,
    color: Color = Color.Green,
    trackColor: Color = Color.Black,
    strokeWidth: Dp = 4.dp,
    visibility: Boolean? = true
) {
    UntouchableLayout(
        modifier = modifier.fillMaxSize(),
        backgroundColor = backgroundColor,
        alpha = alpha,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        visibility = visibility ?: true
    ) {
        CircularProgressIndicator(
            color = color,
            strokeWidth = strokeWidth,
            trackColor = trackColor
        )
    }
}
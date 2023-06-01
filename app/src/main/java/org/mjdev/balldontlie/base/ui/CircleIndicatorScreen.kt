package org.mjdev.balldontlie.base.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import org.mjdev.balldontlie.base.annotations.DayPreview

@DayPreview
@Composable
fun CircleIndicatorScreen(
    modifier: Modifier = Modifier,
    backgroundColor: Color = MaterialTheme.colorScheme.secondary,
    alpha: Float = 0.3f,
    color: Color = MaterialTheme.colorScheme.tertiary,
    trackColor: Color = MaterialTheme.colorScheme.secondary,
    strokeWidth: Dp = 5.dp,
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
package org.mjdev.balldontlie.base.annotations

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.ui.tooling.preview.Preview

/**
 * Day night preview.
 *
 * Composable annotation to show night version of app.
 *
 * @constructor Create empty constructor for day night preview
 */
@Preview(
    uiMode = UI_MODE_NIGHT_YES,
    showBackground = true
)
annotation class NightPreview


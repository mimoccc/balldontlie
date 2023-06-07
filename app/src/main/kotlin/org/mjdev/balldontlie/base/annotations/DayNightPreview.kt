package org.mjdev.balldontlie.base.annotations

import android.content.res.Configuration
import androidx.compose.ui.tooling.preview.Preview

/**
 * Day night preview.
 *
 * Composable annotation to show day and night version of app.
 *
 * @constructor Create empty constructor for day night preview
 */
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_NO,
    showBackground = true
)
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true
)
annotation class DayNightPreview

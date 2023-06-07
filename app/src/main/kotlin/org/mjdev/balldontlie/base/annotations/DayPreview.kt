package org.mjdev.balldontlie.base.annotations

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import androidx.compose.ui.tooling.preview.Preview

/**
 * Day night preview.
 *
 * Composable annotation to show day version of app.
 *
 * @constructor Create empty constructor for day night preview
 */
@Preview(
    uiMode = UI_MODE_NIGHT_NO,
    showBackground = true
)
annotation class DayPreview


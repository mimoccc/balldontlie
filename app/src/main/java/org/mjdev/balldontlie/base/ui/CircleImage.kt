package org.mjdev.balldontlie.base.ui

import android.annotation.SuppressLint
import android.graphics.drawable.ColorDrawable
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import org.mjdev.balldontlie.R
import org.mjdev.balldontlie.base.annotations.DayPreview
import org.mjdev.balldontlie.base.helpers.Ext.previewData

@SuppressLint("ModifierParameter")
@DayPreview
@Composable
fun CircleImage(
    modifier: Modifier = previewData(Modifier) { Modifier.size(64.dp) },
    backGroundColor: Color = MaterialTheme.colorScheme.secondary,
    borderColor: Color = Color.Black,
    borderSize: Dp = 2.dp,
    contentDescription: String = "",
    src: Any? = previewData { R.drawable.milanj },
) {
    Box(
        modifier = modifier,
        contentAlignment = androidx.compose.ui.Alignment.Center
    ) {
        ImageAny(
            modifier = modifier
                .padding(borderSize)
                .clip(CircleShape),
            src = ColorDrawable(backGroundColor.toArgb()),
            contentDescription = contentDescription,
            contentScale = ContentScale.Crop
        )
        ImageAny(
            modifier = modifier
                .clip(CircleShape)
                .border(borderSize, borderColor, CircleShape),
            src = src,
            contentDescription = contentDescription,
            contentScale = ContentScale.Crop,
        )
    }
}
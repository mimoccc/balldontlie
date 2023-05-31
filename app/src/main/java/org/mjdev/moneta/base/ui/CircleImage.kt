package org.mjdev.moneta.base.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import org.mjdev.moneta.R

@Preview(showBackground = true)
@Composable
@SuppressLint("ModifierParameter") // just for preview
fun CircleImage(
    modifier: Modifier = Modifier.size(50.dp),
    backGroundColor: Color = Color.Black,
    borderColor: Color = Color.White,
    borderSize: Dp = 2.dp,
    contentDescription: String = "",
    src: Any? = R.drawable.person
) {
    Box(
        modifier = modifier,
        contentAlignment = androidx.compose.ui.Alignment.Center
    ) {
        Image(
            modifier = modifier
                .padding(borderSize)
                .clip(CircleShape),
            painter = colorPainter(backGroundColor),
            contentDescription = contentDescription,
            contentScale = ContentScale.Crop
        )
        Image(
            modifier = modifier
                .clip(CircleShape)
                .border(borderSize, borderColor, CircleShape),
            painter = glideResource(src),
            contentDescription = contentDescription,
            contentScale = ContentScale.Crop,
        )
    }
}


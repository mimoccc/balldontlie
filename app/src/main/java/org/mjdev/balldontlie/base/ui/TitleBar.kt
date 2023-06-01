package org.mjdev.balldontlie.base.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import org.mjdev.balldontlie.R
import org.mjdev.balldontlie.base.helpers.Ext.previewData

@Preview(showBackground = true)
@Composable
fun TitleBar(
    modifier: Modifier = Modifier,
    text: Any? = previewData { R.string.app_name },
    verticalAlignment: Alignment.Vertical = Alignment.CenterVertically,
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = verticalAlignment
    ) {
        TextAny(
            text = text,
            maxLines = 1,
            fontWeight = FontWeight.Bold,
            fontSize = TextUnit(24f, TextUnitType.Sp),
            overflow = TextOverflow.Ellipsis
        )
    }
}

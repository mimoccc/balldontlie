package org.mjdev.moneta.ui.components.about

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.mjdev.moneta.R
import org.mjdev.moneta.base.ui.CircleImage
import org.mjdev.moneta.base.ui.HtmlTextView

@Preview(showBackground = true)
@Composable
fun About(
    textColor: Color = Color.White
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircleImage(
            modifier = Modifier.size(96.dp),
            src = R.drawable.milanj
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.Start
        ) {
            HtmlTextView(
                modifier = Modifier
                    .fillMaxWidth(),
                color = textColor,
                htmlStringResource = R.string.developer
            )
            HtmlTextView(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp, 8.dp),
                color = textColor,
                htmlStringResource = R.string.copyright
            )
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(8.dp)
            )
            HtmlTextView(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp, 8.dp),
                htmlStringResource = R.string.email,
                color = textColor,
            )
            HtmlTextView(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp, 8.dp),
                color = textColor,
                htmlStringResource = R.string.webpage
            )
            HtmlTextView(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp, 8.dp),
                color = textColor,
                htmlStringResource = R.string.phone
            )
            HtmlTextView(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp, 8.dp),
                color = textColor,
                htmlStringResource = R.string.github
            )
        }
    }
}

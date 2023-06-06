package org.mjdev.balldontlie.ui.components.about

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
import androidx.compose.ui.unit.dp
import org.mjdev.balldontlie.R
import org.mjdev.balldontlie.base.annotations.DayPreview
import org.mjdev.balldontlie.base.ui.CircleImage
import org.mjdev.balldontlie.base.ui.HtmlTextView

@DayPreview
@Composable
fun About() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(18.dp),
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
                modifier = Modifier.fillMaxWidth(),
                htmlResId = R.string.developer
            )
            HtmlTextView(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp, 8.dp),
                htmlResId = R.string.copyright
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
                htmlResId = R.string.email,
            )
            HtmlTextView(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp, 8.dp),
                htmlResId = R.string.webpage
            )
            HtmlTextView(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp, 8.dp),
                htmlResId = R.string.phone
            )
            HtmlTextView(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp, 8.dp),
                htmlResId = R.string.github
            )
        }
    }
}

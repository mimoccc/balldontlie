package org.mjdev.moneta.ui.components.about

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.mjdev.moneta.R
import org.mjdev.moneta.base.annotations.NightPreview
import org.mjdev.moneta.base.ui.CircleImage
import org.mjdev.moneta.base.ui.HtmlTextView
import org.mjdev.moneta.ui.theme.grayLight

@NightPreview
@Composable
fun About(
    textColor: Color = grayLight,
    backgroundColor: Color = MaterialTheme.colorScheme.surface,
) {
    Card(
        modifier = Modifier.fillMaxSize(),
        colors = CardDefaults.cardColors(
            containerColor = backgroundColor
        ),
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
                    modifier = Modifier.fillMaxWidth(),
                    color = textColor,
                    htmlResId = R.string.developer
                )
                HtmlTextView(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(0.dp, 8.dp),
                    color = textColor,
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
                    color = textColor,
                )
                HtmlTextView(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(0.dp, 8.dp),
                    color = textColor,
                    htmlResId = R.string.webpage
                )
                HtmlTextView(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(0.dp, 8.dp),
                    color = textColor,
                    htmlResId = R.string.phone
                )
                HtmlTextView(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(0.dp, 8.dp),
                    color = textColor,
                    htmlResId = R.string.github
                )
            }
        }
    }
}

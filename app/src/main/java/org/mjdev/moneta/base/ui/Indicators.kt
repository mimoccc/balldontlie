package org.mjdev.moneta.base.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import org.mjdev.moneta.error.ApiError
import org.mjdev.moneta.error.EmptyError

@Preview(showBackground = true)
@Composable
fun CircleIndicatorSmall(
    modifier: Modifier = Modifier,
    color: Color = Color.Green,
    trackColor: Color = Color.Black,
    strokeWidth: Dp = 4.dp
) {
    UntouchableLayout(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator(
            color = color,
            strokeWidth = strokeWidth,
            trackColor = trackColor
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CircleIndicatorScreen(
    modifier: Modifier = Modifier,
    backgroundColor: Color = Color.White,
    alpha: Float = 0.5f,
    color: Color = Color.Green,
    trackColor: Color = Color.Black,
    strokeWidth: Dp = 4.dp,
    visibility: Boolean? = false
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

@Preview(showBackground = true)
@Composable
fun ErrorIndicatorSmall(
    modifier: Modifier = Modifier,
    error: ApiError = ApiError()
) {
    Row(
        modifier = modifier.fillMaxWidth()
    ) {
        when (error) {
            is EmptyError -> {}
            else -> {
                Card(
                    border = BorderStroke(1.dp, Color.White)
                ) {
                    Column(
                        modifier = modifier
                            .background(
                                color = error.backgroundColor
                            ),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(2.dp, 4.dp),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally,
                        ) {
                            Text(
                                text = error.title,
                                color = error.textColor,
                                fontStyle = FontStyle.Normal,
                                fontWeight = FontWeight.Bold,
                                fontSize = TextUnit(14f, TextUnitType.Sp)
                            )
                            Card(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(2.dp, 2.dp),
                                colors = CardDefaults.cardColors(
                                    containerColor = Color.White,
                                )
                            ) {
                                Column(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(8.dp, 4.dp)
                                ) {
                                    Text(
                                        minLines = 2,
                                        style = TextStyle.Default,
                                        text = error.message,
                                        color = Color.Black,
                                        fontStyle = FontStyle.Italic,
                                        fontWeight = FontWeight.Normal,
                                        fontSize = TextUnit(10f, TextUnitType.Sp)
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
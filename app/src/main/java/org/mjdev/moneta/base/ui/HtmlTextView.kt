package org.mjdev.moneta.base.ui

import android.os.Build
import android.text.Html
import android.text.SpannableString
import android.text.Spanned
import android.text.method.LinkMovementMethod
import androidx.annotation.StringRes
import androidx.appcompat.widget.AppCompatTextView
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.viewinterop.AndroidView
import org.mjdev.moneta.R

@Preview(showBackground = true)
@Composable
fun HtmlTextView(
    modifier: Modifier = Modifier,
    @StringRes htmlStringResource: Int = R.string.webpage,
    color: Color = MaterialTheme.colorScheme.tertiary,
    fontSize: TextUnit = TextUnit.Unspecified,
    fontStyle: FontStyle? = null,
    fontWeight: FontWeight? = null,
    fontFamily: FontFamily? = null,
    letterSpacing: TextUnit = TextUnit.Unspecified,
    textDecoration: TextDecoration? = null,
    textAlign: TextAlign? = null,
    lineHeight: TextUnit = TextUnit.Unspecified,
    overflow: TextOverflow = TextOverflow.Clip,
    softWrap: Boolean = true,
    maxLines: Int = Int.MAX_VALUE,
    minLines: Int = 1,
    onTextLayout: (TextLayoutResult) -> Unit = {},
    style: TextStyle = LocalTextStyle.current,
    onClick: (() -> Unit)? = null
) {
    HtmlTextView(
        modifier = modifier,
        html = stringResWithStyling(htmlStringResource).toString(),
        color = color,
        fontSize = fontSize,
        fontStyle = fontStyle,
        fontWeight = fontWeight,
        fontFamily = fontFamily,
        letterSpacing = letterSpacing,
        textDecoration = textDecoration,
        textAlign = textAlign,
        lineHeight = lineHeight,
        overflow = overflow,
        softWrap = softWrap,
        maxLines = maxLines,
        minLines = minLines,
        onTextLayout = onTextLayout,
        style = style,
        onClick = onClick
    )
}

@Preview(showBackground = true)
@Composable
fun HtmlTextView(
    modifier: Modifier = Modifier,
    html: String = "test",
    color: Color = MaterialTheme.colorScheme.tertiary,
    fontSize: TextUnit = TextUnit.Unspecified,
    fontStyle: FontStyle? = null,
    fontWeight: FontWeight? = null,
    fontFamily: FontFamily? = null,
    letterSpacing: TextUnit = TextUnit.Unspecified,
    textDecoration: TextDecoration? = null,
    textAlign: TextAlign? = null,
    lineHeight: TextUnit = TextUnit.Unspecified,
    overflow: TextOverflow = TextOverflow.Clip,
    softWrap: Boolean = true,
    maxLines: Int = Int.MAX_VALUE,
    minLines: Int = 1,
    onTextLayout: (TextLayoutResult) -> Unit = {},
    style: TextStyle = LocalTextStyle.current,
    onClick:(()->Unit)? = null
) {
    AndroidView(
        modifier = modifier,
        factory = { context ->
            AppCompatTextView(context).apply {
                text = fromHtml(html)
                setTextColor(color.toArgb())
                textSize = TextUnit(fontSize.value, TextUnitType.Sp).value
                setLineHeight(lineHeight.value.toInt())
                setMaxLines(maxLines)
                setMinLines(minLines)
                textAlignment = when (textAlign) {
                    TextAlign.Left -> 1
                    TextAlign.Right -> 2
                    TextAlign.Center -> 3
                    TextAlign.Justify -> 4
                    TextAlign.Start -> 5
                    TextAlign.End -> 6
                    else -> 0
                }
                if (onClick == null) {
                    movementMethod = LinkMovementMethod.getInstance()
                } else {
                    setOnClickListener { onClick() }
                }
                // todo all parameters
            }
        }
    )
}

@Composable
fun stringResWithStyling(@StringRes id: Int): CharSequence =
    LocalContext.current.resources.getText(id)

@Suppress("DEPRECATION")
fun fromHtml(html: String?): Spanned {
    return when {
        html == null -> {
            SpannableString("")
        }

        Build.VERSION.SDK_INT >= Build.VERSION_CODES.N -> {
            Html.fromHtml(html, Html.FROM_HTML_MODE_LEGACY)
        }

        else -> {
            Html.fromHtml(html)
        }
    }
}
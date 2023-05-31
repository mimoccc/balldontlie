package org.mjdev.moneta.base.ui

import android.graphics.drawable.ColorDrawable
import android.view.MotionEvent
import android.widget.FrameLayout
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView

@Preview(showBackground = true)
@Composable
fun UntouchableLayout(
    modifier: Modifier = Modifier,
    backgroundColor: Color = Color.Transparent,
    alpha: Float = 0.5f,
    verticalArrangement: Arrangement.Vertical = Arrangement.Top,
    horizontalAlignment: Alignment.Horizontal = Alignment.Start,
    visibility: Boolean = true,
    content: @Composable () -> Unit = {}
) {
    if (visibility) {
        Box(
            modifier = modifier
        ) {
            AndroidView(
                modifier = modifier,
                factory = { context ->
                    object : FrameLayout(context) {
                        init {
                            background = ColorDrawable(backgroundColor.toArgb())
                            setAlpha(alpha)
                        }

                        override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
                            return true
                        }
                    }
                }
            )
            Column(
                modifier = modifier,
                verticalArrangement = verticalArrangement,
                horizontalAlignment = horizontalAlignment,
            ) {
                content()
            }
        }
    }
}
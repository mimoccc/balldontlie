package org.mjdev.balldontlie.base.ui

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.drawable.Drawable
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.toBitmap
import com.bumptech.glide.Glide
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

@SuppressLint("CheckResult")
suspend fun loadGlideResource(
    context: Context,
    src: Any? = null,
    placeHolder: Int? = null,
    width: Int,
    height: Int
): Painter {
    val placeHolderDrawable = placeHolder?.let {
        ContextCompat.getDrawable(context, placeHolder)
    }
    return withContext(Dispatchers.IO) {
        Glide.with(context)
            .asBitmap()
            .load(src)
            .apply {
                if (placeHolderDrawable != null) {
                    placeholder(placeHolderDrawable)
                }
            }
            .submit(width, height)
            .get()
    }.asImageBitmap().let { bmp ->
        BitmapPainter(bmp)
    }
}

@SuppressLint("CheckResult")
@Composable
fun glideResource(
    src: Any? = null,
    placeHolder: Int? = null,
    width: Int = 1,
    height: Int = 1
): Painter {
    val context = LocalContext.current
    return when (src) {
        is Int -> painterResource(src)
        is Drawable -> BitmapPainter(src.toBitmap().asImageBitmap())
        else -> runBlocking(Dispatchers.IO) {
            loadGlideResource(context, src, placeHolder, width, height)
        }
    }
}
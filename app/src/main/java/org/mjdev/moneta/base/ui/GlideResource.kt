package org.mjdev.moneta.base.ui

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import androidx.compose.runtime.Composable
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.toBitmap
import com.bumptech.glide.Glide
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import timber.log.Timber

fun colorPainter(
    color: Color = Color.Black,
    size: Size = Size(50f, 50f)
) = ColorDrawable(color.toArgb())
    .toBitmap(size.width.toInt(), size.height.toInt())
    .asImageBitmap()
    .let { bmp ->
        BitmapPainter(bmp)
    }

@SuppressLint("CheckResult")
suspend fun loadGlideResource(
    context: Context,
    src: Any? = null,
    placeHolder: Int? = null
): Painter {
    val placeHolderDrawable = try {
        placeHolder?.let {
            ContextCompat.getDrawable(context, placeHolder)
        }
    } catch (e: Exception) {
        Timber.e(e)
        null
    }
    return try {
        withContext(Dispatchers.IO) {
            Glide.with(context)
                .asBitmap()
                .load(src)
                .apply {
                    if (placeHolderDrawable != null) {
                        placeholder(placeHolderDrawable)
                    }
                }
                .submit()
                .get()
        }.asImageBitmap().let { bmp ->
            BitmapPainter(bmp)
        }
    } catch (e: Exception) {
        Timber.e(e)
        placeHolderDrawable
            ?.toBitmap()
            ?.asImageBitmap()
            ?.let { bmp ->
                BitmapPainter(bmp)
            }
    } ?: colorPainter()
}

@SuppressLint("CheckResult")
@Composable
fun glideResource(
    src: Any? = null,
    placeHolder: Int? = null
): Painter {
    val context = LocalContext.current
    return when (src) {
        is Int -> painterResource(src)
        is Drawable -> BitmapPainter(src.toBitmap().asImageBitmap())
        else -> runBlocking(Dispatchers.IO) {
            loadGlideResource(context, src, placeHolder)
        }
    }
}
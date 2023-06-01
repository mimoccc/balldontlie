package org.mjdev.balldontlie.glide

import android.content.Context
import android.graphics.Bitmap
import android.util.Log
import com.bumptech.glide.Glide
import com.bumptech.glide.GlideBuilder
import com.bumptech.glide.Registry
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.integration.okhttp3.OkHttpUrlLoader
import com.bumptech.glide.load.DecodeFormat
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool
import com.bumptech.glide.load.engine.cache.DiskLruCacheFactory
import com.bumptech.glide.load.engine.cache.ExternalPreferredCacheDiskCacheFactory
import com.bumptech.glide.load.engine.cache.InternalCacheDiskCacheFactory
import com.bumptech.glide.load.engine.cache.LruResourceCache
import com.bumptech.glide.load.engine.cache.MemorySizeCalculator
import com.bumptech.glide.load.model.GlideUrl
import com.bumptech.glide.module.AppGlideModule
import com.bumptech.glide.request.RequestOptions
import okhttp3.OkHttpClient
import org.mjdev.balldontlie.BuildConfig
import java.io.InputStream
import java.util.concurrent.TimeUnit

@Suppress("unused")
@GlideModule
class MyAppGlideModule : AppGlideModule() {

    enum class CacheType { NONE, INTERNAL, EXTERNAL }

    private val cacheType: CacheType = CacheType.EXTERNAL

    private val memoryScreens = 1F

    private val diskCacheSizeBytes: Long = 256 * 1024 * 1024

    private val client: OkHttpClient by lazy {
        OkHttpClient.Builder()
            .readTimeout(20, TimeUnit.SECONDS)
            .connectTimeout(20, TimeUnit.SECONDS)
            .build()
    }

    private val requestOptions by lazy {
        RequestOptions()
            .format(DecodeFormat.PREFER_ARGB_8888)
            .disallowHardwareConfig()
            .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
            .dontAnimate()
            .dontTransform()
            .encodeFormat(Bitmap.CompressFormat.PNG)
            .encodeQuality(100)
    }

    private fun cacheFactory(context: Context): DiskLruCacheFactory? {
        return when (cacheType) {
            CacheType.INTERNAL -> InternalCacheDiskCacheFactory(context, diskCacheSizeBytes)
            CacheType.EXTERNAL -> return ExternalPreferredCacheDiskCacheFactory(context)
            else -> null
        }
    }

    private fun calculator(context: Context) = MemorySizeCalculator.Builder(context)
        .setMemoryCacheScreens(memoryScreens)
        .build()

    override fun isManifestParsingEnabled(): Boolean {
        return false
    }

    override fun applyOptions(context: Context, builder: GlideBuilder) {
        val cache = LruResourceCache(calculator(context).memoryCacheSize.toLong())
        val bitmapPool = LruBitmapPool(calculator(context).bitmapPoolSize.toLong())
        with(builder) {
            setMemoryCache(cache)
            setBitmapPool(bitmapPool)
            cacheFactory(context)?.also { c ->
                setDiskCache(c)
            }
            setDefaultRequestOptions(requestOptions)
            if (BuildConfig.DEBUG) {
                setLogLevel(Log.VERBOSE)
            } else {
                setLogLevel(Log.ERROR)
            }
        }
    }

    override fun registerComponents(context: Context, glide: Glide, registry: Registry) {
        registry.replace(
            GlideUrl::class.java,
            InputStream::class.java,
            OkHttpUrlLoader.Factory(client)
        )
    }

}
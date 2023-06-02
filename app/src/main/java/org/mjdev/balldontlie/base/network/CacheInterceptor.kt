package org.mjdev.balldontlie.base.network

import okhttp3.CacheControl
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException
import java.util.concurrent.TimeUnit

class CacheInterceptor(
    private val maxAge: Int = 1,
    private val timeUnit: TimeUnit = TimeUnit.HOURS
) : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val response: Response = chain.proceed(chain.request())
        val cacheControl: CacheControl = CacheControl.Builder()
            .maxAge(maxAge, timeUnit)
            .build()
        return response.newBuilder()
            .removeHeader("Pragma")
            .removeHeader("Cache-Control")
            .header("Cache-Control", cacheControl.toString())
            .build()
    }

}
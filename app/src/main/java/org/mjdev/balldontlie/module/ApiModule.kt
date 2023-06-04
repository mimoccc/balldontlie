package org.mjdev.balldontlie.module

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.mjdev.balldontlie.BuildConfig
import org.mjdev.balldontlie.network.ApiService
import org.mjdev.balldontlie.base.network.CacheInterceptor
import org.mjdev.balldontlie.repository.ApiRepository
import org.mjdev.balldontlie.repository.IRepository
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ProvideModule {

    @Suppress("PrivatePropertyName")
    private val BASE_URL = BuildConfig.API_URL

    private val isDebug = BuildConfig.DEBUG

//    private val CACHE_SIZE = 64L * 1024L * 1024L // 64 MiB

    @Singleton
    @Provides
    fun providesHttpLoggingInterceptor(
    ) = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    @Singleton
    @Provides
    fun providesCacheInterceptor() = CacheInterceptor()

    @Singleton
    @Provides
    fun providesOkHttpClient(
        cacheInterceptor: CacheInterceptor,
        httpLoggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient = OkHttpClient.Builder().apply {
        addNetworkInterceptor(cacheInterceptor)
        if (isDebug) {
            addInterceptor(httpLoggingInterceptor)
        }
    }.build()

    @Singleton
    @Provides
    fun providesRetrofit(
        okHttpClient: OkHttpClient
    ): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(MoshiConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .build()

    @Singleton
    @Provides
    fun providesApiService(
        retrofit: Retrofit
    ): ApiService = retrofit.create(ApiService::class.java)

    @Singleton
    @Provides
    fun providesMoshi(): Moshi = Moshi.Builder().build()

    @Singleton
    @Provides
    fun providesApiRepository(
        apiService: ApiService
    ): IRepository = ApiRepository(apiService)

}
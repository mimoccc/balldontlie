package org.mjdev.moneta.module

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.mjdev.moneta.BuildConfig
import org.mjdev.moneta.network.ApiService
import org.mjdev.moneta.repository.ApiRepository
import org.mjdev.moneta.repository.IRepository
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    private const val BASE_URL = BuildConfig.API_URL

    private val isDebug = BuildConfig.DEBUG

    @Singleton
    @Provides
    fun providesHttpLoggingInterceptor(
    ) = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    @Singleton
    @Provides
    fun providesOkHttpClient(
        httpLoggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient = OkHttpClient.Builder().apply {
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
    fun providesApiRepository(
        apiService: ApiService
    ) : IRepository = ApiRepository(apiService)

}
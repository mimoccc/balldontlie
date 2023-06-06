//[app](../../../index.md)/[org.mjdev.balldontlie.module](../index.md)/[ProvideModule](index.md)

# ProvideModule

[androidJvm]\
@Module

class [ProvideModule](index.md)

## Constructors

| | |
|---|---|
| [ProvideModule](-provide-module.md) | [androidJvm]<br>constructor() |

## Functions

| Name | Summary |
|---|---|
| [provideDAO](provide-d-a-o.md) | [androidJvm]<br>@Singleton<br>@Provides<br>fun [provideDAO](provide-d-a-o.md)(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html)): [DAO](../../org.mjdev.balldontlie.database/-d-a-o/index.md) |
| [providesApiRepository](provides-api-repository.md) | [androidJvm]<br>@Singleton<br>@Provides<br>fun [providesApiRepository](provides-api-repository.md)(apiService: [ApiService](../../org.mjdev.balldontlie.network/-api-service/index.md)): [INetworkRepository](../../org.mjdev.balldontlie.repository.def/-i-network-repository/index.md) |
| [providesApiService](provides-api-service.md) | [androidJvm]<br>@Singleton<br>@Provides<br>fun [providesApiService](provides-api-service.md)(retrofit: Retrofit): [ApiService](../../org.mjdev.balldontlie.network/-api-service/index.md) |
| [providesCacheInterceptor](provides-cache-interceptor.md) | [androidJvm]<br>@Singleton<br>@Provides<br>fun [providesCacheInterceptor](provides-cache-interceptor.md)(): [CacheInterceptor](../../org.mjdev.balldontlie.base.network/-cache-interceptor/index.md) |
| [providesHttpLoggingInterceptor](provides-http-logging-interceptor.md) | [androidJvm]<br>@Singleton<br>@Provides<br>fun [providesHttpLoggingInterceptor](provides-http-logging-interceptor.md)(): HttpLoggingInterceptor |
| [providesMoshi](provides-moshi.md) | [androidJvm]<br>@Singleton<br>@Provides<br>fun [providesMoshi](provides-moshi.md)(): Moshi |
| [providesOkHttpClient](provides-ok-http-client.md) | [androidJvm]<br>@Singleton<br>@Provides<br>fun [providesOkHttpClient](provides-ok-http-client.md)(cacheInterceptor: [CacheInterceptor](../../org.mjdev.balldontlie.base.network/-cache-interceptor/index.md), httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient |
| [providesRetrofit](provides-retrofit.md) | [androidJvm]<br>@Singleton<br>@Provides<br>fun [providesRetrofit](provides-retrofit.md)(okHttpClient: OkHttpClient): Retrofit |
| [providesSyncRepository](provides-sync-repository.md) | [androidJvm]<br>@Singleton<br>@Provides<br>fun [providesSyncRepository](provides-sync-repository.md)(dao: [DAO](../../org.mjdev.balldontlie.database/-d-a-o/index.md)): [IRepository](../../org.mjdev.balldontlie.repository.def/-i-repository/index.md) |

package com.muffar.dailyclip.di

import com.muffar.dailyclip.data.source.remote.MovieApi
import com.muffar.dailyclip.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
    @Provides
    fun provideOkhttpClient(): OkHttpClient {
        val httpLoggingInterceptor = HttpLoggingInterceptor().setLevel(
            if (BuildConfig.DEBUG) {
                HttpLoggingInterceptor.Level.BODY
            } else {
                HttpLoggingInterceptor.Level.NONE
            }
        )

        return OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .addInterceptor {chain ->
                val original = chain.request()
                val request = original.newBuilder()
                    .addHeader("accept", "application/json")
                    .addHeader("Authorization", "Bearer ${BuildConfig.API_KEY}")
                    .build()
                chain.proceed(request)
            }
            .connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
            .build()
    }

    @Provides
    fun provideApiService(client: OkHttpClient): MovieApi {
        val retrofit = Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL_API)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(MovieApi::class.java)
    }
}
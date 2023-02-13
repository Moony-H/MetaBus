package com.moonyh.metabus.di

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.experimental.CoroutineCallAdapterFactory
import com.moonyh.data.call.ApiResponseCallAdapterFactory
import com.moonyh.data.common.TimeOut
import com.moonyh.data.common.Url
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Qualifier
import javax.inject.Singleton

@Qualifier
annotation class ArrivalInfoRetrofit

@Qualifier
annotation class CityInfoRetrofit

@Qualifier
annotation class StationInfoRetrofit

@InstallIn(SingletonComponent::class)
@Module
class RetrofitModule {

    @ArrivalInfoRetrofit
    @Singleton
    @Provides
    fun providesArrivalInfoRetrofit(): Retrofit {
        val okHttpClient = OkHttpClient().newBuilder()
            .connectTimeout(TimeOut.TIMEOUT_CONNECT, TimeUnit.SECONDS)
            .readTimeout(TimeOut.TIMEOUT_READ, TimeUnit.SECONDS)
            .writeTimeout(TimeOut.TIMEOUT_WRITE, TimeUnit.SECONDS)
            .build()

        return Retrofit.Builder()
            .baseUrl(Url.ARRIVAL_INFO_SERVICE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(ApiResponseCallAdapterFactory.create())
            .build()
    }

    @CityInfoRetrofit
    @Singleton
    @Provides
    fun providesCityInfoRetrofit(): Retrofit {
        val okHttpClient = OkHttpClient().newBuilder()
            .connectTimeout(TimeOut.TIMEOUT_CONNECT, TimeUnit.SECONDS)
            .readTimeout(TimeOut.TIMEOUT_READ, TimeUnit.SECONDS)
            .writeTimeout(TimeOut.TIMEOUT_WRITE, TimeUnit.SECONDS)
            .build()

        return Retrofit.Builder()
            .baseUrl(Url.CITY_INFO_SERVICE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .addCallAdapterFactory(ApiResponseCallAdapterFactory.create())
            .build()
    }

    @StationInfoRetrofit
    @Singleton
    @Provides
    fun providesStationInfoRetrofit(): Retrofit {
        val okHttpClient = OkHttpClient().newBuilder()
            .connectTimeout(TimeOut.TIMEOUT_CONNECT, TimeUnit.SECONDS)
            .readTimeout(TimeOut.TIMEOUT_READ, TimeUnit.SECONDS)
            .writeTimeout(TimeOut.TIMEOUT_WRITE, TimeUnit.SECONDS)
            .build()

        return Retrofit.Builder()
            .baseUrl(Url.STATION_INFO_SERVICE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .addCallAdapterFactory(ApiResponseCallAdapterFactory.create())
            .build()
    }
}
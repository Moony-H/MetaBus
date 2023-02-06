package com.moonyh.metabus.di

import com.moonyh.data.service.ArrivalInfoService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class ArrivalInfoServiceModule {


    @Singleton
    @Provides
    fun providesArrivalInfoService(@ArrivalInfoRetrofit retrofit: Retrofit):ArrivalInfoService{
        return retrofit.create(ArrivalInfoService::class.java)
    }
}
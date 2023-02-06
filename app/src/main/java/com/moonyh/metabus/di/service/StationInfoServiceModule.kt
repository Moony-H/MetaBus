package com.moonyh.metabus.di.service

import com.moonyh.data.service.StationInfoService
import com.moonyh.metabus.di.StationInfoRetrofit
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class StationInfoServiceModule {

    @Singleton
    @Provides
    fun providesStationInfoService(@StationInfoRetrofit retrofit:Retrofit):StationInfoService{
        return retrofit.create(StationInfoService::class.java)
    }
}
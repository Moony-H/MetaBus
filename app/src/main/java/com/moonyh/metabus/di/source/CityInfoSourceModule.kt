package com.moonyh.metabus.di.source

import com.moonyh.data.source.CityInfoSource
import com.moonyh.data.source.CityInfoSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class CityInfoSourceModule {

    @Singleton
    @Provides
    fun providesCityInfoSource(source: CityInfoSourceImpl): CityInfoSource {
        return source
    }
}
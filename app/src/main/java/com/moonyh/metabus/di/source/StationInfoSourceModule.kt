package com.moonyh.metabus.di.source

import com.moonyh.data.source.StationInfoSource
import com.moonyh.data.source.StationInfoSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class StationInfoSourceModule {

    @Singleton
    @Provides
    fun providesStationInfoSource(source: StationInfoSourceImpl): StationInfoSource {
        return source
    }
}


package com.moonyh.metabus.di.source

import com.moonyh.data.source.ArrivalInfoSource
import com.moonyh.data.source.ArrivalInfoSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class ArrivalInfoSourceModule {

    @Singleton
    @Provides
    fun providesArrivalInfoSource(source: ArrivalInfoSourceImpl): ArrivalInfoSource {
        return source
    }
}
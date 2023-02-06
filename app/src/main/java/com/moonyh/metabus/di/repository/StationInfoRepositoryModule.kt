package com.moonyh.metabus.di.repository

import com.moonyh.data.StationRepositoryImpl
import com.moonyh.domain.repository.StationRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class StationInfoRepositoryModule {

    @Singleton
    @Provides
    fun providesStationInfoRepository(repository: StationRepositoryImpl):StationRepository{
        return repository
    }
}
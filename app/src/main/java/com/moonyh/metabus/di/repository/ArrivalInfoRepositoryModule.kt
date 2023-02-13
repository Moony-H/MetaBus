package com.moonyh.metabus.di.repository

import com.moonyh.data.ArrivalInfoRepositoryImpl
import com.moonyh.domain.repository.ArrivalInfoRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class ArrivalInfoRepositoryModule {
    @Singleton
    @Provides
    fun providesArrivalInfoRepository(repository:ArrivalInfoRepositoryImpl):ArrivalInfoRepository{
        return repository
    }
}
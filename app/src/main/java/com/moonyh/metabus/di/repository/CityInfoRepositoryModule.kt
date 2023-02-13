package com.moonyh.metabus.di.repository

import com.moonyh.data.CityRepositoryImpl
import com.moonyh.domain.repository.CityRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class CityInfoRepositoryModule {
    @Singleton
    @Provides
    fun providesCityInfoRepository(repository: CityRepositoryImpl): CityRepository {
        return repository
    }
}
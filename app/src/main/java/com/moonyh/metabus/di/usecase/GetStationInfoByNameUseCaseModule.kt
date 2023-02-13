package com.moonyh.metabus.di.usecase

import com.moonyh.domain.repository.StationRepository
import com.moonyh.domain.usecase.GetStationInfoByNameUseCase
import com.moonyh.domain.usecase.GetStationInfoByNameUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class GetStationInfoByNameUseCaseModule {
    @Singleton
    @Provides
    fun providesGetStationInfoByNameUseCase(repository: StationRepository) :GetStationInfoByNameUseCase=
        GetStationInfoByNameUseCaseImpl(repository)
}
package com.moonyh.metabus.di.usecase

import com.moonyh.domain.repository.StationRepository
import com.moonyh.domain.usecase.GetStationInfoByGpsUseCase
import com.moonyh.domain.usecase.GetStationInfoByGpsUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class GetStationInfoByGpsUseCaseModule {
    @Singleton
    @Provides
    fun providesGetStationInfoByGpsUseCase(repository: StationRepository) :GetStationInfoByGpsUseCase=
        GetStationInfoByGpsUseCaseImpl(repository)
}
package com.moonyh.metabus.di.usecase

import com.moonyh.domain.repository.StationRepository
import com.moonyh.domain.usecase.GetBusInStationUseCase
import com.moonyh.domain.usecase.GetBusInStationUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class GetBusInStationUseCaseModule {

    @Singleton
    @Provides
    fun providesGetBusInStationUseCase(repository: StationRepository): GetBusInStationUseCase =
        GetBusInStationUseCaseImpl(repository)
}
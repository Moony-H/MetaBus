package com.moonyh.metabus.di.usecase

import com.moonyh.domain.repository.ArrivalInfoRepository
import com.moonyh.domain.usecase.GetBusArrivalInfoInStationUseCase
import com.moonyh.domain.usecase.GetBusArrivalInfoInStationUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class GetBusArrivalInfoInStationUseCaseModule {

    @Singleton
    @Provides
    fun providesBusArrivalInfoInStationUseCaseImpl(arrivalInfoRepository: ArrivalInfoRepository): GetBusArrivalInfoInStationUseCase =
        GetBusArrivalInfoInStationUseCaseImpl(arrivalInfoRepository)

}
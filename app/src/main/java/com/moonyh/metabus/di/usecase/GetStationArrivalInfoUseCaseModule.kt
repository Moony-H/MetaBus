package com.moonyh.metabus.di.usecase

import com.moonyh.domain.repository.ArrivalInfoRepository
import com.moonyh.domain.usecase.GetStationArrivalInfoUseCase
import com.moonyh.domain.usecase.GetStationArrivalInfoUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class GetStationArrivalInfoUseCaseModule {

    @Singleton
    @Provides
    fun providesGetStationArrivalInfoUseCase(repository: ArrivalInfoRepository): GetStationArrivalInfoUseCase =
        GetStationArrivalInfoUseCaseImpl(repository)
}
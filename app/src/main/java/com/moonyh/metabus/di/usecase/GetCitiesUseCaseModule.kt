package com.moonyh.metabus.di.usecase

import com.moonyh.domain.repository.CityRepository
import com.moonyh.domain.usecase.GetCitiesUseCase
import com.moonyh.domain.usecase.GetCitiesUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton



@InstallIn(SingletonComponent::class)
@Module
class GetCitiesUseCaseModule {

    @Singleton
    @Provides
    fun providesGetCitiesUseCase(repository: CityRepository):GetCitiesUseCase =
        GetCitiesUseCaseImpl(repository)
}
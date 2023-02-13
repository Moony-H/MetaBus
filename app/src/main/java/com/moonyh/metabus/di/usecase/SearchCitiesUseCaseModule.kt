package com.moonyh.metabus.di.usecase

import com.moonyh.domain.usecase.SearchCitiesUseCase
import com.moonyh.domain.usecase.SearchCitiesUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class SearchCitiesUseCaseModule {

    @Singleton
    @Provides
    fun providesSearchCitiesUseCaseModule():SearchCitiesUseCase = SearchCitiesUseCaseImpl()
}
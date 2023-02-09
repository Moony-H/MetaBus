package com.moonyh.domain.usecase

import com.moonyh.domain.model.body.CitiesInfoBody
import com.moonyh.domain.model.normal.ApiResponse
import com.moonyh.domain.model.query.CitiesInfoQuery
import com.moonyh.domain.repository.CityRepository
import com.moonyh.domain.usecase.base.ApiUseCase


abstract class GetCitiesUseCase : ApiUseCase<CitiesInfoQuery, CitiesInfoBody> {
    abstract override suspend fun invoke(query: CitiesInfoQuery): ApiResponse<CitiesInfoBody>
}

class GetCitiesUseCaseImpl(private val cityRepository: CityRepository) : GetCitiesUseCase() {
    override suspend fun invoke(query: CitiesInfoQuery): ApiResponse<CitiesInfoBody> {
        return cityRepository.getCities(query)
    }

}
package com.moonyh.data

import com.moonyh.data.source.CityInfoSource
import com.moonyh.domain.model.body.CitiesInfoBody
import com.moonyh.domain.model.normal.ApiResponse
import com.moonyh.domain.model.query.CitiesInfoQuery
import com.moonyh.domain.repository.CityRepository
import javax.inject.Inject

class CityRepositoryImpl @Inject constructor(private val cityInfoSource: CityInfoSource):CityRepository {

    override suspend fun getCities(cityQuery: CitiesInfoQuery): ApiResponse<CitiesInfoBody> {
        return cityInfoSource.getCities(cityQuery)
    }
}
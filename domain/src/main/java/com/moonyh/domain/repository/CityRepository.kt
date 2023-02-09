package com.moonyh.domain.repository

import com.moonyh.domain.model.normal.ApiResponse
import com.moonyh.domain.model.body.CitiesInfoBody
import com.moonyh.domain.model.query.CitiesInfoQuery

interface CityRepository : Repository {
    suspend fun getCities(cityQuery: CitiesInfoQuery): ApiResponse<CitiesInfoBody>
}
package com.moonyh.domain.repository

import com.moonyh.domain.model.normal.ApiResponse
import com.moonyh.domain.model.body.CitiesInfoBody

interface CityRepository {
    fun getCities():ApiResponse<CitiesInfoBody>
}
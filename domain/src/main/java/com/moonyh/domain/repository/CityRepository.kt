package com.moonyh.domain.repository

import com.moonyh.domain.model.normal.ApiResponse
import com.moonyh.domain.model.response.CityInfoResponse

interface CityRepository {
    fun getCities():ApiResponse<CityInfoResponse>
}
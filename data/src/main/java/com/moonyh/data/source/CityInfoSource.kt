package com.moonyh.data.source

import com.moonyh.data.model.response.CitiesInfo
import com.moonyh.data.service.CityInfoService
import com.moonyh.domain.model.normal.ApiResponse
import com.moonyh.domain.model.query.CitiesInfoQuery
import javax.inject.Inject

interface CityInfoSource {
    suspend fun getCities(citiesInfoQuery: CitiesInfoQuery):ApiResponse<CitiesInfo>
}

class CityInfoSourceImpl @Inject constructor(private val cityInfoService: CityInfoService):CityInfoSource{
    override suspend fun getCities(citiesInfoQuery: CitiesInfoQuery): ApiResponse<CitiesInfo> {
        val result=cityInfoService.getCities(citiesInfoQuery.key,"json")
        return ApiResponse(result.code(),result.body(),result.errorBody()?.string())
    }

}
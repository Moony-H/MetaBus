package com.moonyh.domain.usecase

import com.moonyh.domain.model.api.body.StationInfoBody
import com.moonyh.domain.model.normal.ApiResponse
import com.moonyh.domain.model.normal.onError
import com.moonyh.domain.model.api.query.StationInfoByNameQuery
import com.moonyh.domain.repository.StationRepository
import com.moonyh.domain.usecase.base.ApiUseCase

abstract class GetStationInfoByNameUseCase() :
    ApiUseCase<StationInfoByNameQuery, StationInfoBody> {
    abstract override suspend fun invoke(query: StationInfoByNameQuery): ApiResponse<StationInfoBody>
}

class GetStationInfoByNameUseCaseImpl(private val stationRepository: StationRepository) :
    GetStationInfoByNameUseCase() {
    override suspend fun invoke(query: StationInfoByNameQuery): ApiResponse<StationInfoBody> {
        val response=stationRepository.getStationInfoByName(query)
        if(response is ApiResponse.Exception<StationInfoBody>){
            val message=response.e.message
            if(message!=null && "Expected BEGIN_OBJECT" in message)
                return ApiResponse.NoResponse()
        }
        return response
    }
}
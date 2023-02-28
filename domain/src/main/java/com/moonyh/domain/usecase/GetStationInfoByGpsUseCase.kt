package com.moonyh.domain.usecase

import com.moonyh.domain.model.api.body.StationInfoBody
import com.moonyh.domain.model.normal.ApiResponse
import com.moonyh.domain.model.api.query.StationInfoByGpsQuery
import com.moonyh.domain.repository.StationRepository
import com.moonyh.domain.usecase.base.ApiUseCase


abstract class GetStationInfoByGpsUseCase :
    ApiUseCase<StationInfoByGpsQuery, StationInfoBody> {
    abstract override suspend fun invoke(query: StationInfoByGpsQuery): ApiResponse<StationInfoBody>
}

class GetStationInfoByGpsUseCaseImpl(private val stationRepository: StationRepository) :
    GetStationInfoByGpsUseCase() {
    override suspend fun invoke(query: StationInfoByGpsQuery): ApiResponse<StationInfoBody> {
        return stationRepository.getStationInfoByGPS(query)
    }
}
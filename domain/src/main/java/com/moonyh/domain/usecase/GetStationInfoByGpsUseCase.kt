package com.moonyh.domain.usecase

import com.moonyh.domain.model.body.StationInfoBody
import com.moonyh.domain.model.normal.ApiResponse
import com.moonyh.domain.model.query.StationInfoByGpsQuery
import com.moonyh.domain.repository.StationRepository


abstract class GetStationInfoByGpsUseCase :
    UseCase<StationInfoByGpsQuery, StationInfoBody> {
    abstract override suspend fun invoke(query: StationInfoByGpsQuery): ApiResponse<StationInfoBody>

}

class GetStationInfoByGpsUseCaseImpl(private val stationRepository: StationRepository) :
    GetStationInfoByGpsUseCase() {
    override suspend fun invoke(query: StationInfoByGpsQuery): ApiResponse<StationInfoBody> {
        return stationRepository.getStationInfoByGPS(query)
    }
}
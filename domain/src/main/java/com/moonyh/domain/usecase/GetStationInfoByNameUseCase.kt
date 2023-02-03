package com.moonyh.domain.usecase

import com.moonyh.domain.model.body.StationInfoBody
import com.moonyh.domain.model.normal.ApiResponse
import com.moonyh.domain.model.query.StationInfoByNameQuery
import com.moonyh.domain.repository.StationRepository

abstract class GetStationInfoByNameUseCase() :
    UseCase<StationInfoByNameQuery, StationInfoBody> {
    abstract override suspend fun invoke(query: StationInfoByNameQuery): ApiResponse<StationInfoBody>

}

class GetStationInfoByNameUseCaseImpl(private val stationRepository: StationRepository) :
    GetStationInfoByNameUseCase() {
    override suspend fun invoke(query: StationInfoByNameQuery): ApiResponse<StationInfoBody> {
        return stationRepository.getStationInfoByName(query)
    }
}
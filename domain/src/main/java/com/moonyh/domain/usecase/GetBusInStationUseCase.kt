package com.moonyh.domain.usecase

import com.moonyh.domain.model.body.BusInStationInfoBody
import com.moonyh.domain.model.normal.ApiResponse
import com.moonyh.domain.model.query.BusInStationQuery
import com.moonyh.domain.repository.StationRepository
import com.moonyh.domain.usecase.base.ApiUseCase

abstract class GetBusInStationUseCase : ApiUseCase<BusInStationQuery, BusInStationInfoBody> {
    abstract override suspend fun invoke(query: BusInStationQuery): ApiResponse<BusInStationInfoBody>
}

class GetBusInStationUseCaseImpl(private val stationRepository: StationRepository) :
    GetBusInStationUseCase() {
    override suspend fun invoke(query: BusInStationQuery): ApiResponse<BusInStationInfoBody> {
        return stationRepository.getBusInStation(query)
    }
}
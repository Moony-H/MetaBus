package com.moonyh.domain.usecase

import com.moonyh.domain.model.api.ApiResponse
import com.moonyh.domain.model.api.body.BusInStationInfoBody
import com.moonyh.domain.model.api.query.BusInStationQuery
import com.moonyh.domain.repository.StationRepository
import com.moonyh.domain.usecase.base.ApiUseCase

abstract class GetBusInStationUseCase : ApiUseCase<BusInStationQuery, BusInStationInfoBody> {
    abstract override suspend operator fun invoke(query: BusInStationQuery): ApiResponse<BusInStationInfoBody>
}

class GetBusInStationUseCaseImpl(private val stationRepository: StationRepository) :
    GetBusInStationUseCase() {
    override suspend operator fun invoke(query: BusInStationQuery): ApiResponse<BusInStationInfoBody> {
        return stationRepository.getBusInStation(query)
    }
}
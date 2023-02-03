package com.moonyh.domain.usecase

import com.moonyh.domain.model.body.BusInStationBody
import com.moonyh.domain.model.normal.ApiResponse
import com.moonyh.domain.model.query.BusInStationQuery
import com.moonyh.domain.repository.StationRepository

abstract class GetBusInStationUseCase : UseCase<BusInStationQuery, BusInStationBody> {
    abstract override suspend fun invoke(query: BusInStationQuery): ApiResponse<BusInStationBody>
}

class GetBusInStationUseCaseImpl(private val stationRepository: StationRepository) :
    GetBusInStationUseCase() {
    override suspend fun invoke(query: BusInStationQuery): ApiResponse<BusInStationBody> {
        return stationRepository.getBusInStation(query)
    }
}
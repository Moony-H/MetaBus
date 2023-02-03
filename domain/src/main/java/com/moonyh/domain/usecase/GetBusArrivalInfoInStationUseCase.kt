package com.moonyh.domain.usecase

import com.moonyh.domain.model.body.BusArrivalInfoInStationBody
import com.moonyh.domain.model.normal.ApiResponse
import com.moonyh.domain.model.query.BusArrivalInfoInStationQuery
import com.moonyh.domain.repository.ArrivalInfoRepository

abstract class GetBusArrivalInfoInStationUseCase :
    UseCase<BusArrivalInfoInStationQuery, BusArrivalInfoInStationBody> {
    abstract override suspend fun invoke(query: BusArrivalInfoInStationQuery): ApiResponse<BusArrivalInfoInStationBody>

}
class GetBusArrivalInfoInStationUseCaseImpl(private val arrivalInfoRepository: ArrivalInfoRepository) :
    GetBusArrivalInfoInStationUseCase() {
    override suspend fun invoke(query: BusArrivalInfoInStationQuery): ApiResponse<BusArrivalInfoInStationBody> {
        return arrivalInfoRepository.getBusArrivalInfoInStation(query)
    }

}
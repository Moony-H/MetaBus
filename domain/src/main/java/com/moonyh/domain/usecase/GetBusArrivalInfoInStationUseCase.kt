package com.moonyh.domain.usecase

import com.moonyh.domain.model.api.ApiResponse
import com.moonyh.domain.model.api.body.BusArrivalInStationInfoBody
import com.moonyh.domain.model.api.query.BusArrivalInfoInStationQuery
import com.moonyh.domain.repository.ArrivalInfoRepository
import com.moonyh.domain.usecase.base.ApiUseCase

abstract class GetBusArrivalInfoInStationUseCase :
    ApiUseCase<BusArrivalInfoInStationQuery, BusArrivalInStationInfoBody> {
    abstract override suspend operator fun invoke(query: BusArrivalInfoInStationQuery): ApiResponse<BusArrivalInStationInfoBody>
}

class GetBusArrivalInfoInStationUseCaseImpl(private val arrivalInfoRepository: ArrivalInfoRepository) :
    GetBusArrivalInfoInStationUseCase() {
    override suspend operator fun invoke(query: BusArrivalInfoInStationQuery): ApiResponse<BusArrivalInStationInfoBody> {
        return arrivalInfoRepository.getBusArrivalInfoInStation(query)
    }

}
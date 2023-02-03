package com.moonyh.domain.usecase

import com.moonyh.domain.model.body.CitiesInfoBody
import com.moonyh.domain.model.body.StationArrivalInfoBody
import com.moonyh.domain.model.normal.ApiResponse
import com.moonyh.domain.model.query.CitiesInfoQuery
import com.moonyh.domain.model.query.StationArrivalInfoQuery
import com.moonyh.domain.repository.ArrivalInfoRepository
import com.moonyh.domain.repository.StationRepository

abstract class GetStationArrivalInfoUseCase :
    UseCase<StationArrivalInfoQuery, StationArrivalInfoBody> {
    abstract override suspend fun invoke(query: StationArrivalInfoQuery): ApiResponse<StationArrivalInfoBody>

}

class GetStationArrivalInfoUseCaseImpl(private val arrivalInfoRepository: ArrivalInfoRepository) :
    GetStationArrivalInfoUseCase() {
    override suspend fun invoke(query: StationArrivalInfoQuery): ApiResponse<StationArrivalInfoBody> {
        return arrivalInfoRepository.getStationArrivalInfo(query)
    }
}
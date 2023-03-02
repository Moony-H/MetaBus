package com.moonyh.data

import com.moonyh.data.source.ArrivalInfoSource
import com.moonyh.domain.model.api.ApiResponse
import com.moonyh.domain.model.api.body.BusArrivalInStationInfoBody
import com.moonyh.domain.model.api.body.StationArrivalInfoBody
import com.moonyh.domain.model.api.query.BusArrivalInfoInStationQuery
import com.moonyh.domain.model.api.query.StationArrivalInfoQuery
import com.moonyh.domain.repository.ArrivalInfoRepository
import javax.inject.Inject

class ArrivalInfoRepositoryImpl @Inject constructor(private val arrivalInfoSource: ArrivalInfoSource) :
    ArrivalInfoRepository {

    override suspend fun getBusArrivalInfoInStation(busArrivalInfoInStationQuery: BusArrivalInfoInStationQuery): ApiResponse<BusArrivalInStationInfoBody> {
        return arrivalInfoSource.getBusArrivalInStationInfo(busArrivalInfoInStationQuery)
    }

    override suspend fun getStationArrivalInfo(stationArrivalInfoQuery: StationArrivalInfoQuery): ApiResponse<StationArrivalInfoBody> {
        return arrivalInfoSource.getStationArrivalInfo(stationArrivalInfoQuery)
    }
}
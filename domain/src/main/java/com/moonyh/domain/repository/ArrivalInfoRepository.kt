package com.moonyh.domain.repository

import com.moonyh.domain.model.normal.ApiResponse
import com.moonyh.domain.model.query.BusArrivalInfoInStationQuery
import com.moonyh.domain.model.body.BusArrivalInStationInfoBody
import com.moonyh.domain.model.body.StationArrivalInfoBody
import com.moonyh.domain.model.query.StationArrivalInfoQuery

interface ArrivalInfoRepository:Repository {
    suspend fun getStationArrivalInfo(
        stationArrivalInfoQuery: StationArrivalInfoQuery
    ): ApiResponse<StationArrivalInfoBody>

    suspend fun getBusArrivalInfoInStation(
        busArrivalInfoInStationQuery: BusArrivalInfoInStationQuery
    ): ApiResponse<BusArrivalInStationInfoBody>

}
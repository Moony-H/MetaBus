package com.moonyh.domain.repository

import com.moonyh.domain.model.normal.ApiResponse
import com.moonyh.domain.model.api.query.BusArrivalInfoInStationQuery
import com.moonyh.domain.model.api.body.BusArrivalInStationInfoBody
import com.moonyh.domain.model.api.body.StationArrivalInfoBody
import com.moonyh.domain.model.api.query.StationArrivalInfoQuery

interface ArrivalInfoRepository : Repository {
    suspend fun getStationArrivalInfo(
        stationArrivalInfoQuery: StationArrivalInfoQuery
    ): ApiResponse<StationArrivalInfoBody>

    suspend fun getBusArrivalInfoInStation(
        busArrivalInfoInStationQuery: BusArrivalInfoInStationQuery
    ): ApiResponse<BusArrivalInStationInfoBody>

}
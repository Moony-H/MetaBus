package com.moonyh.domain.repository

import com.moonyh.domain.model.normal.ApiResponse
import com.moonyh.domain.model.response.BusArrivalInfoInStationResponse
import com.moonyh.domain.model.response.StationArrivalInfoResponse

interface ArrivalInfoRepository {
    suspend fun getStationArrivalInfo(
        key: String,
        pageNum: Int,
        cityCode: String,
        stationId: String
    ): ApiResponse<StationArrivalInfoResponse>

    suspend fun getBusArrivalInfoInStation(
        key: String,
        pageNum: Int,
        cityCode: String,
        stationId: String,
        busId: String
    ): ApiResponse<BusArrivalInfoInStationResponse>

}
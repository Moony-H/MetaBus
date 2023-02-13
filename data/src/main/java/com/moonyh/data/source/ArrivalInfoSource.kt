package com.moonyh.data.source

import com.moonyh.data.model.response.BusArrivalInStationResponseData
import com.moonyh.data.model.response.StationArrivalResponseData
import com.moonyh.data.service.ArrivalInfoService
import com.moonyh.domain.model.body.BusArrivalInStationInfoBody
import com.moonyh.domain.model.body.StationArrivalInfoBody
import com.moonyh.domain.model.normal.ApiResponse
import com.moonyh.domain.model.query.BusArrivalInfoInStationQuery
import com.moonyh.domain.model.query.StationArrivalInfoQuery
import javax.inject.Inject

interface ArrivalInfoSource {
    suspend fun getBusArrivalInStationInfo(query: BusArrivalInfoInStationQuery): ApiResponse<BusArrivalInStationResponseData>
    suspend fun getStationArrivalInfo(query: StationArrivalInfoQuery): ApiResponse<StationArrivalResponseData>
}

class ArrivalInfoSourceImpl @Inject constructor(private val arrivalInfoService: ArrivalInfoService) :
    ArrivalInfoSource {
    override suspend fun getBusArrivalInStationInfo(query: BusArrivalInfoInStationQuery): ApiResponse<BusArrivalInStationResponseData> {
        return arrivalInfoService.getBusInStationArrivalInfo(
            query.key,
            query.itemCount,
            query.page,
            "json",
            query.cityCode,
            query.stationId,
            query.busId
        )
    }

    override suspend fun getStationArrivalInfo(query: StationArrivalInfoQuery): ApiResponse<StationArrivalResponseData> {
        return arrivalInfoService.getStationArrivalInfo(
            query.key,
            query.itemCount,
            query.page,
            "json",
            query.cityCode,
            query.stationId
        )
    }

}
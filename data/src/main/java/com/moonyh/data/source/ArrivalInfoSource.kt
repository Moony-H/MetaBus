package com.moonyh.data.source

import com.moonyh.data.service.ArrivalInfoService
import com.moonyh.domain.model.body.BusArrivalInStationInfoBody
import com.moonyh.domain.model.body.StationArrivalInfoBody
import com.moonyh.domain.model.normal.ApiResponse
import com.moonyh.domain.model.query.BusArrivalInfoInStationQuery
import com.moonyh.domain.model.query.BusInStationQuery
import com.moonyh.domain.model.query.StationArrivalInfoQuery
import retrofit2.Retrofit
import javax.inject.Inject

interface ArrivalInfoSource {
    suspend fun getBusArrivalInStationInfo(query: BusArrivalInfoInStationQuery): ApiResponse<BusArrivalInStationInfoBody>
    suspend fun getStationArrivalInfo(query: StationArrivalInfoQuery): ApiResponse<StationArrivalInfoBody>
}

class ArrivalInfoSourceImpl @Inject constructor(private val arrivalInfoService: ArrivalInfoService) :
    ArrivalInfoSource {
    override suspend fun getBusArrivalInStationInfo(query: BusArrivalInfoInStationQuery): ApiResponse<BusArrivalInStationInfoBody> {
        val response = arrivalInfoService.getBusInStationArrivalInfo(
            query.key,
            query.itemCount,
            query.page,
            "json",
            query.cityCode,
            query.stationId,
            query.busId
        )
        return ApiResponse(response.code(), response.body(), response.errorBody()?.string())
    }

    override suspend fun getStationArrivalInfo(query: StationArrivalInfoQuery): ApiResponse<StationArrivalInfoBody> {
        val response = arrivalInfoService.getStationArrivalInfo(
            query.key,
            query.itemCount,
            query.page,
            "json",
            query.cityCode,
            query.stationId
        )
        return ApiResponse(response.code(), response.body(), response.errorBody()?.string())
    }

}
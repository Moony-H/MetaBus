package com.moonyh.data.source

import com.moonyh.data.model.response.BusInStationInfo
import com.moonyh.data.model.response.StationInfo
import com.moonyh.data.service.StationInfoService
import com.moonyh.domain.model.normal.ApiResponse
import com.moonyh.domain.model.query.BusInStationQuery
import com.moonyh.domain.model.query.StationInfoByGpsQuery
import com.moonyh.domain.model.query.StationInfoByNameQuery
import javax.inject.Inject

interface StationInfoSource {
    suspend fun getStationByName(query: StationInfoByNameQuery): ApiResponse<StationInfo>
    suspend fun getStationByGps(query: StationInfoByGpsQuery): ApiResponse<StationInfo>
    suspend fun getBusInStation(query: BusInStationQuery): ApiResponse<BusInStationInfo>
}

class StationInfoSourceImpl @Inject constructor(private val stationInfoService: StationInfoService) :
    StationInfoSource {
    override suspend fun getBusInStation(query: BusInStationQuery): ApiResponse<BusInStationInfo> {
        val result = stationInfoService.getBusInStation(
            query.key,
            query.itemCount,
            query.page,
            "json",
            query.cityCode,
            query.stationId
        )
        return ApiResponse(result.code(), result.body(), result.errorBody()?.string())
    }

    override suspend fun getStationByName(query: StationInfoByNameQuery): ApiResponse<StationInfo> {
        val result = stationInfoService.getStationByName(
            query.key,
            query.itemCount,
            query.page,
            "json",
            query.cityCode,
            query.stationName,
            query.stationId
        )
        return ApiResponse(result.code(), result.body(), result.errorBody()?.string())
    }

    override suspend fun getStationByGps(query: StationInfoByGpsQuery): ApiResponse<StationInfo> {
        val result = stationInfoService.getStationByGps(
            query.key,
            query.itemCount,
            query.page,
            "json",
            query.lat,
            query.lng
        )
        return ApiResponse(result.code(), result.body(), result.errorBody()?.string())

    }
}
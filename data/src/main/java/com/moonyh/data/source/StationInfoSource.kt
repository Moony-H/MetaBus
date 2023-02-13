package com.moonyh.data.source

import com.moonyh.data.model.response.BusInStationResponseData
import com.moonyh.data.model.response.StationResponseData
import com.moonyh.data.service.StationInfoService
import com.moonyh.domain.model.normal.ApiResponse
import com.moonyh.domain.model.query.BusInStationQuery
import com.moonyh.domain.model.query.StationInfoByGpsQuery
import com.moonyh.domain.model.query.StationInfoByNameQuery
import javax.inject.Inject

interface StationInfoSource {
    suspend fun getStationByName(query: StationInfoByNameQuery): ApiResponse<StationResponseData>
    suspend fun getStationByGps(query: StationInfoByGpsQuery): ApiResponse<StationResponseData>
    suspend fun getBusInStation(query: BusInStationQuery): ApiResponse<BusInStationResponseData>
}

class StationInfoSourceImpl @Inject constructor(private val stationInfoService: StationInfoService) :
    StationInfoSource {
    override suspend fun getBusInStation(query: BusInStationQuery): ApiResponse<BusInStationResponseData> {
        return stationInfoService.getBusInStation(
            query.key,
            query.itemCount,
            query.page,
            "json",
            query.cityCode,
            query.stationId
        )
    }

    override suspend fun getStationByName(query: StationInfoByNameQuery): ApiResponse<StationResponseData> {
        return stationInfoService.getStationByName(
            query.key,
            query.itemCount,
            query.page,
            "json",
            query.cityCode,
            query.stationName,
            query.stationId
        )
    }

    override suspend fun getStationByGps(query: StationInfoByGpsQuery): ApiResponse<StationResponseData> {
        return stationInfoService.getStationByGps(
            query.key,
            query.itemCount,
            query.page,
            "json",
            query.lat,
            query.lng
        )

    }
}
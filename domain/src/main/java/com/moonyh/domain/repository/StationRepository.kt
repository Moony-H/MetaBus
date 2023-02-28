package com.moonyh.domain.repository

import com.moonyh.domain.model.normal.ApiResponse
import com.moonyh.domain.model.api.body.BusInStationInfoBody
import com.moonyh.domain.model.api.body.StationInfoBody
import com.moonyh.domain.model.api.query.BusInStationQuery
import com.moonyh.domain.model.api.query.StationInfoByGpsQuery
import com.moonyh.domain.model.api.query.StationInfoByNameQuery

interface StationRepository : Repository {
    suspend fun getStationInfoByGPS(stationInfoByGpsQuery: StationInfoByGpsQuery): ApiResponse<StationInfoBody>
    suspend fun getStationInfoByName(stationInfoByNameQuery: StationInfoByNameQuery): ApiResponse<StationInfoBody>
    suspend fun getBusInStation(busInStationQuery: BusInStationQuery): ApiResponse<BusInStationInfoBody>
}
package com.moonyh.domain.repository

import com.moonyh.domain.model.normal.ApiResponse
import com.moonyh.domain.model.body.BusInStationInfoBody
import com.moonyh.domain.model.body.StationInfoBody
import com.moonyh.domain.model.query.BusInStationQuery
import com.moonyh.domain.model.query.StationInfoByGpsQuery
import com.moonyh.domain.model.query.StationInfoByNameQuery

interface StationRepository : Repository {
    suspend fun getStationInfoByGPS(stationInfoByGpsQuery: StationInfoByGpsQuery): ApiResponse<StationInfoBody>
    suspend fun getStationInfoByName(stationInfoByNameQuery: StationInfoByNameQuery): ApiResponse<StationInfoBody>
    suspend fun getBusInStation(busInStationQuery: BusInStationQuery): ApiResponse<BusInStationInfoBody>
}
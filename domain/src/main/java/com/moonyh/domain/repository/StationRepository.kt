package com.moonyh.domain.repository

import com.moonyh.domain.model.normal.ApiResponse
import com.moonyh.domain.model.body.BusInStationBody
import com.moonyh.domain.model.body.StationInfoBody
import com.moonyh.domain.model.query.BusInStationQuery
import com.moonyh.domain.model.query.StationInfoByGpsQuery
import com.moonyh.domain.model.query.StationInfoByNameQuery

interface StationRepository {
    fun getStationInfoByGPS(stationInfoByGpsQuery: StationInfoByGpsQuery):ApiResponse<StationInfoBody>
    fun getStationInfoByName(stationInfoByNameQuery: StationInfoByNameQuery):ApiResponse<StationInfoBody>
    fun getBusInStation(busInStationQuery: BusInStationQuery):ApiResponse<BusInStationBody>
}
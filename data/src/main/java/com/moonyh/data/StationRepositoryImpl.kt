package com.moonyh.data

import com.moonyh.data.source.StationInfoSource
import com.moonyh.domain.model.api.body.BusInStationInfoBody
import com.moonyh.domain.model.api.body.StationInfoBody
import com.moonyh.domain.model.normal.ApiResponse
import com.moonyh.domain.model.api.query.BusInStationQuery
import com.moonyh.domain.model.api.query.StationInfoByGpsQuery
import com.moonyh.domain.model.api.query.StationInfoByNameQuery
import com.moonyh.domain.repository.StationRepository
import javax.inject.Inject

class StationRepositoryImpl @Inject constructor(private val stationInfoSource: StationInfoSource) :
    StationRepository {
    override suspend fun getStationInfoByGPS(stationInfoByGpsQuery: StationInfoByGpsQuery): ApiResponse<StationInfoBody> {
        return stationInfoSource.getStationByGps(stationInfoByGpsQuery)
    }

    override suspend fun getStationInfoByName(stationInfoByNameQuery: StationInfoByNameQuery): ApiResponse<StationInfoBody> {
        return stationInfoSource.getStationByName(stationInfoByNameQuery)
    }

    override suspend fun getBusInStation(busInStationQuery: BusInStationQuery): ApiResponse<BusInStationInfoBody> {
        return stationInfoSource.getBusInStation(busInStationQuery)
    }

}
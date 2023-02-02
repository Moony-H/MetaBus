package com.moonyh.domain.repository

import com.moonyh.domain.model.normal.ApiResponse
import com.moonyh.domain.model.response.BusInStationResponse
import com.moonyh.domain.model.response.StationInfoResponse

interface StationRepository {
    fun getStationInfoByGPS(key: String,lat:Double,lng:Double):ApiResponse<StationInfoResponse>
    fun getStationInfoByName(key: String,cityCode: String,stationName:String):ApiResponse<StationInfoResponse>
    fun getBusInStation(key:String,cityCode:String,stationNumber:String):ApiResponse<BusInStationResponse>
}
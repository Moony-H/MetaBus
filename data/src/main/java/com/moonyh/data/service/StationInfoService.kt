package com.moonyh.data.service

import com.moonyh.data.model.response.BusInStationResponseData
import com.moonyh.data.model.response.StationResponseData
import com.moonyh.domain.model.api.ApiResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface StationInfoService {

    //base url: http://apis.data.go.kr/1613000/BusSttnInfoInqireService/

    @GET("getSttnNoList")
    suspend fun getStationByName(
        @Query("serviceKey")
        key:String,
        @Query("numOfRows")
        itemCount:Int,
        @Query("pageNo")
        page: Int,
        @Query("_type")
        type: String="json",
        @Query("cityCode")
        cityCode:String,
        @Query("nodeNm")
        stationName:String,
        @Query("nodeId")
        stationId:String?
    ): ApiResponse<StationResponseData>

    @GET("getCrdntPrxmtSttnList")
    suspend fun getStationByGps(
        @Query("serviceKey")
        key: String,
        @Query("numOfRows")
        itemCount:Int,
        @Query("pageNo")
        page: Int,
        @Query("_type")
        type: String="json",
        @Query("gpsLati")
        latitude:Double,
        @Query("gpsLong")
        longitude:Double,
    ):ApiResponse<StationResponseData>

    @GET("getSttnThrghRouteList")
    suspend fun getBusInStation(
        @Query("serviceKey")
        key: String,
        @Query("numOfRows")
        itemCount:Int,
        @Query("pageNo")
        page: Int,
        @Query("_type")
        type: String="json",
        @Query("cityCode")
        cityCode: String,
        @Query("nodeid")
        stationId:String,

    ):ApiResponse<BusInStationResponseData>
}
package com.moonyh.data.service

import com.moonyh.data.model.response.BusArrivalInStationInfo
import com.moonyh.data.model.response.StationArrivalInfo
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ArrivalInfoService {

    //base url: http://apis.data.go.kr/1613000/ArvlInfoInqireService/
    @GET("getSttnAcctoArvlPrearngeInfoList")
    suspend fun getStationArrivalInfo(
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
        @Query("nodeId")
        stationId:String,

    ): Response<StationArrivalInfo>

    @GET("getSttnAcctoSpcifyRouteBusArvlPrearngeInfoList")
    suspend fun getBusInStationArrivalInfo(
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
        @Query("nodeId")
        stationId:String,
        @Query("routeId")
        busId:String,


    ):Response<BusArrivalInStationInfo>
}
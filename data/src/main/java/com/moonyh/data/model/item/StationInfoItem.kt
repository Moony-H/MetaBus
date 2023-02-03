package com.moonyh.data.model.item

import com.google.gson.annotations.SerializedName
import com.moonyh.domain.model.StationInfo

data class StationInfoItem(
    @SerializedName("gpslati")
    val _lat:Double,
    @SerializedName("gpslong")
    val _lng:Double,
    @SerializedName("nodeid")
    val _stationId:String,
    @SerializedName("nodenm")
    val _stationName:String,
    @SerializedName("nodeno")
    val _stationNum:String,

): StationInfo {
    override val id: String
        get() = _stationId
    override val name: String
        get() = _stationName
    override val number: String
        get() = _stationNum
    override val lat: Double
        get() = _lat
    override val lng: Double
        get() = _lng

}
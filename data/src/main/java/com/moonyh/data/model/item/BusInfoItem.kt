package com.moonyh.data.model.item

import com.google.gson.annotations.SerializedName
import com.moonyh.domain.model.BusInfo

data class BusInfoItem(
    @SerializedName("nodeid")
    val _stationId: String = "",
    @SerializedName("nodenm")
    val _stationName: String = "",
    @SerializedName("routeid")
    val _id: String = "",
    @SerializedName("routeno")
    val _number: String = "",
    @SerializedName("routetp")
    val _lineType: String = "",
    @SerializedName("arrprevstationcnt")
    val _remainStation: Int = -1,
    @SerializedName("arrtime")
    val _remainTimeSec: Int = -1,
    @SerializedName("vehicletp")
    val _busType: String = "",
    @SerializedName("endnodenm")
    val _endStation: String = "",
    @SerializedName("startnodenm")
    val _startStation: String = "",

    ) : BusInfo {
    override val id = _id
    override val number = _number
    override val lineType = _lineType
    override val endStation = _endStation
    override val startStation = _startStation
    override val remainStation = _remainStation
    override val remainTimeSec = _remainTimeSec
    override val busType = _busType

}
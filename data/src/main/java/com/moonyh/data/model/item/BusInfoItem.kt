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
    override val id
        get() = _id
    override val number
        get() = _number
    override val lineType
        get() = _lineType
    override val endStation
        get() = _endStation
    override val startStation
        get() = _startStation
    override val remainStation
        get() = _remainStation
    override val remainTimeSec
        get() = _remainTimeSec
    override val busType
        get() = _busType

}
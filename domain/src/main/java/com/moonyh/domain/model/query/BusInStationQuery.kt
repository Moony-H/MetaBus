package com.moonyh.domain.model.query

import com.moonyh.domain.model.normal.ApiQuery

data class BusInStationQuery(
    val key:String,
    val cityCode:String,
    val stationId:String,
    var page: Int=1,
    var itemCount:Int=10
):ApiQuery

package com.moonyh.domain.model.query

import com.moonyh.domain.model.normal.ApiQuery

data class BusInStationQuery(
    val key:String,
    val cityCode:String,
    val stationNumber:String
):ApiQuery

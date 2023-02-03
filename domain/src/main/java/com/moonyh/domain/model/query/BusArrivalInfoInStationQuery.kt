package com.moonyh.domain.model.query

import com.moonyh.domain.model.normal.ApiQuery

data class BusArrivalInfoInStationQuery(
    val key: String,
    val cityCode: String,
    val stationId: String,
    val busId: String,
    val pageNum: Int=1
) : ApiQuery


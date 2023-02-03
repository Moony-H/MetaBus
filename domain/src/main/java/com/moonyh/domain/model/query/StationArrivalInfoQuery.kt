package com.moonyh.domain.model.query

import com.moonyh.domain.model.normal.ApiQuery

data class StationArrivalInfoQuery(
    val key: String,
    val cityCode: String,
    val stationId: String,
    val pageNum: Int=1
): ApiQuery
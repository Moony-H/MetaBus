package com.moonyh.domain.model.query

import com.moonyh.domain.model.normal.ApiQuery

data class StationInfoByGpsQuery(
    val key: String,
    val lat:Double,
    val lng:Double
):ApiQuery
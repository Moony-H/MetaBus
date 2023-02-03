package com.moonyh.domain.model.query

import com.moonyh.domain.model.normal.ApiQuery

data class StationInfoByNameQuery(
    val key: String,
    val cityCode: String,
    val stationName:String
):ApiQuery
package com.moonyh.domain.model.api.query

import com.moonyh.domain.model.api.base.ApiQuery

data class StationInfoByGpsQuery(
    val key: String,
    val lat:Double,
    val lng:Double,
    var page: Int=1,
    var itemCount:Int=10
): ApiQuery
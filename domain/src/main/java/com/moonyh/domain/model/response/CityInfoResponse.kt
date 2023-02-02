package com.moonyh.domain.model.response

import com.moonyh.domain.model.CityInfo
import com.moonyh.domain.model.normal.MetaData

interface CityInfoResponse {
    val metaData:MetaData
    val items:ArrayList<CityInfo>
}
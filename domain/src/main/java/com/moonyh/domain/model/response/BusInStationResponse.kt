package com.moonyh.domain.model.response

import com.moonyh.domain.model.BusInfo
import com.moonyh.domain.model.normal.MetaData

interface BusInStationResponse {
    val metaData:MetaData
    val items:ArrayList<BusInfo>
}
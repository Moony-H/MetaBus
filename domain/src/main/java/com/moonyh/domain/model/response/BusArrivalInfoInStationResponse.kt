package com.moonyh.domain.model.response

import com.moonyh.domain.model.BusInfo
import com.moonyh.domain.model.normal.MetaData

interface BusArrivalInfoInStationResponse {
    val metaData:MetaData
    val items:ArrayList<BusInfo>
}
package com.moonyh.domain.model.response

import com.moonyh.domain.model.StationInfo
import com.moonyh.domain.model.normal.MetaData

interface StationInfoResponse {
    val metaData:MetaData
    val items:ArrayList<StationInfo>
}
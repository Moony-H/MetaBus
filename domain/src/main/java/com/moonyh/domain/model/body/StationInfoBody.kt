package com.moonyh.domain.model.body

import com.moonyh.domain.model.StationInfo
import com.moonyh.domain.model.normal.ApiBody
import com.moonyh.domain.model.normal.MetaData

interface StationInfoBody:ApiBody {
    val metaData:MetaData
    val items:ArrayList<StationInfo>
}
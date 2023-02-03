package com.moonyh.domain.model.body

import com.moonyh.domain.model.BusInfo
import com.moonyh.domain.model.normal.ApiBody
import com.moonyh.domain.model.normal.MetaData

interface BusInStationInfoBody:ApiBody{
    val metaData:MetaData
    val items:ArrayList<out BusInfo>
}
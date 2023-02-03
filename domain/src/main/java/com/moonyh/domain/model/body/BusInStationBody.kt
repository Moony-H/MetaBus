package com.moonyh.domain.model.body

import com.moonyh.domain.model.BusInfo
import com.moonyh.domain.model.normal.ApiBody
import com.moonyh.domain.model.normal.MetaData

interface BusInStationBody:ApiBody{
    val metaData:MetaData
    val items:ArrayList<BusInfo>
}
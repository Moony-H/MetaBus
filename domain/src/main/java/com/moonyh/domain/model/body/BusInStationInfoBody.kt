package com.moonyh.domain.model.body

import com.moonyh.domain.model.BusInfo
import com.moonyh.domain.model.normal.ApiBody
import com.moonyh.domain.model.normal.MetaData

interface BusInStationInfoBody : ApiBody<MetaData, ArrayList<out BusInfo>> {
    override val metaData: MetaData
    override val items: ArrayList<out BusInfo>
}
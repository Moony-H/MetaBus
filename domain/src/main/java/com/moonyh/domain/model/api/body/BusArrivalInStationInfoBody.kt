package com.moonyh.domain.model.api.body

import com.moonyh.domain.model.info.BusInfo
import com.moonyh.domain.model.api.base.ApiBody
import com.moonyh.domain.model.api.MetaData


interface BusArrivalInStationInfoBody : ApiBody<MetaData, ArrayList<out BusInfo>> {
    override val metaData: MetaData
    override val items: ArrayList<out BusInfo>
}
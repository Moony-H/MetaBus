package com.moonyh.domain.model.body

import com.moonyh.domain.model.StationInfo
import com.moonyh.domain.model.normal.ApiBody
import com.moonyh.domain.model.normal.MetaData

interface StationInfoBody : ApiBody<MetaData, ArrayList<out StationInfo>> {
    override val metaData: MetaData
    override val items: ArrayList<out StationInfo>
}
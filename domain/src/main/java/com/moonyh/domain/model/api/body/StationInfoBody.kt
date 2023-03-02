package com.moonyh.domain.model.api.body

import com.moonyh.domain.model.info.StationInfo
import com.moonyh.domain.model.api.base.ApiBody
import com.moonyh.domain.model.api.MetaData

interface StationInfoBody : ApiBody<MetaData, ArrayList<out StationInfo>> {
    override val metaData: MetaData
    override val items: ArrayList<out StationInfo>
}
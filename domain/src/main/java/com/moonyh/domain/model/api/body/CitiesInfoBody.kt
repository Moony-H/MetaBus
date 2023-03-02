package com.moonyh.domain.model.api.body

import com.moonyh.domain.model.info.CityInfo
import com.moonyh.domain.model.api.base.ApiBody
import com.moonyh.domain.model.api.MetaData

interface CitiesInfoBody : ApiBody<MetaData, ArrayList<out CityInfo>> {
    override val metaData: MetaData
    override val items: ArrayList<out CityInfo>
}
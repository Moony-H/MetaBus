package com.moonyh.domain.model.body

import com.moonyh.domain.model.CityInfo
import com.moonyh.domain.model.normal.ApiBody
import com.moonyh.domain.model.normal.MetaData

interface CitiesInfoBody : ApiBody<MetaData, ArrayList<out CityInfo>> {
    override val metaData: MetaData
    override val items: ArrayList<out CityInfo>
}
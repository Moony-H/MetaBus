package com.moonyh.domain.model.body

import com.moonyh.domain.model.CityInfo
import com.moonyh.domain.model.normal.ApiBody
import com.moonyh.domain.model.normal.MetaData

interface CitiesInfoBody:ApiBody {
    val metaData:MetaData
    val items:ArrayList<out CityInfo>
}
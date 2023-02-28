package com.moonyh.data.model.item

import com.google.gson.annotations.SerializedName
import com.moonyh.domain.model.info.CityInfo

data class CityInfoItem(
    @SerializedName("citycode")
    val _cityCode:String="",
    @SerializedName("cityname")
    val _cityName:String=""
): CityInfo {
    override val cityCode: String
        get() = _cityCode
    override val cityName: String
        get() = _cityName
}
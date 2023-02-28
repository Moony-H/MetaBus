package com.moonyh.domain.model.info

//실제 뷰에 노출 시킬 데이터
interface CityInfo : BaseInfo {
    val cityCode: String
    val cityName: String
}
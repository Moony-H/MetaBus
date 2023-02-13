package com.moonyh.domain.model

//실제 뷰에 노출 시킬 데이터
interface CityInfo : Info {
    val cityCode: String
    val cityName: String
}
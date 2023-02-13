package com.moonyh.domain.model

//실제 뷰에 노출 시킬 데이터
interface StationInfo : Info {
    val id: String
    val name: String
    val number: String
    val lat: Double
    val lng: Double
}
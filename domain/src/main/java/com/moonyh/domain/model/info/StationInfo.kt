package com.moonyh.domain.model.info

//실제 뷰에 노출 시킬 데이터
interface StationInfo : BaseInfo {
    val id: String
    val name: String
    val number: String
    val lat: Double
    val lng: Double
}
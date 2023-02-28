package com.moonyh.domain.model.info


//실제 뷰에 노출 시킬 데이터
interface BusInfo : BaseInfo {
    val id: String
    val number: String
    val lineType: String
    val remainStation: Int
    val remainTimeSec: Int
    val busType: String
    val endStation: String
    val startStation: String
}
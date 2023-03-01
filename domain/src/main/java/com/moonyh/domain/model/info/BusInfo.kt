package com.moonyh.domain.model.info

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


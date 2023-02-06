package com.moonyh.domain.model

interface BusInfo {
    val id:String
    val number:String
    val lineType:String
    val remainStation:Int
    val remainTimeSec:Int
    val busType:String
    val endStation:String
    val startStation:String
}
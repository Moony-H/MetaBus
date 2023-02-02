package com.moonyh.domain.model

import com.moonyh.domain.model.normal.Pageable

interface StationInfo {
    val id:String
    val name:String
    val number:String
    val lat:Double
    val lng:Double
}
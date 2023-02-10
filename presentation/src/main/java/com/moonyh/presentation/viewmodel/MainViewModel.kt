package com.moonyh.presentation.viewmodel

import androidx.lifecycle.ViewModel

class MainViewModel:ViewModel() {

    private var _cityCode:String=""
    val cityCode:String
        get()=_cityCode

    private var _stationId:String=""
    val stationId:String
        get()=_stationId

    private var _busIds= arrayListOf<String>()
    val busIds:List<String>
        get()=_busIds

    fun setCityCode(cityCode:String){
        _cityCode=cityCode
    }

    fun setStationId(stationId:String){
        _stationId=stationId
    }

    fun addBusId(busId:String){
        _busIds.add(busId)
    }


}
package com.moonyh.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.moonyh.domain.model.BusInfo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewModel:ViewModel() {

    private var _cityCode:String=""
    val cityCode:String
        get()=_cityCode

    private var _stationId:String=""
    val stationId:String
        get()=_stationId

    private var _selectedBusInfoList= MutableStateFlow(HashMap<String,BusInfo>())
    val selectedBusInfoList=_selectedBusInfoList.asStateFlow()

    fun setCityCode(cityCode:String){
        _cityCode=cityCode
    }

    fun setStationId(stationId:String){
        _stationId=stationId
    }

    fun addSelectedBus(busInfo: BusInfo){
        viewModelScope.launch(Dispatchers.IO){
            Log.e("test","added")
            _selectedBusInfoList.value[busInfo.id]=busInfo
            Log.e("test","bus info hash: ${_selectedBusInfoList.value}")
            _selectedBusInfoList.value=(HashMap(_selectedBusInfoList.value))
        }
    }

    fun removeSelectedBus(busInfo: BusInfo){
        viewModelScope.launch(Dispatchers.IO){
            _selectedBusInfoList.value.remove(busInfo.id)
            _selectedBusInfoList.value=(HashMap(_selectedBusInfoList.value))
        }
    }


}